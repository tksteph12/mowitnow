package mowitnow.data;

/**
 * @author Stephane TATCHUM
 *
 */
public class Position {

	private int x; // abscisse
	private int y; // oordonnée
	private Direction direction;

	/**
	 * @param x
	 * @param y
	 * @param direction
	 */
	public Position(int x, int y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	/**
	 *  Création de position à partir d'une ligne du fichier
	 * @param ligneFichier
	 */
	
	public Position(String ligneFichier){
		String[] coords = ligneFichier.split(" ");
		assert(coords.length==3): "The length of this array should be 3";
		x = Integer.parseInt(coords[0]);
		y = Integer.parseInt(coords[1]);
		direction = new Direction(coords[2].charAt(0));
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	/**
	 * Methode pour pivoter vers la droite
	 */
	public void pivoterDroite(){
		direction = direction.droite();
	}
	/**
	 * methode pour pivote à gauche
	 */
	public void pivoterGauche(){
		direction= direction.gauche();
	}
	
	/**
	 * Faire avancer dans la pelouse
	 * @param pelouse
	 * @return
	 */
	public Position avancer(final Pelouse pelouse){
		
		Position position = this;
		//vérifier si la tondeuse peut avancer sur la pelouse.
		if(!peutAvancer(pelouse)){
			return position;
		}
		
		// Ne marchera que sur jvm >= 1.7
		switch(direction.toString()){
		case  "N" :
				y =y+1;
				position= new Position(x, y, direction);
			break;
		case "S" :
				y = y-1;
				position = new Position(x, y, direction);
			break;
		case "E" :
				x =x+ 1;
				position =  new Position(x, y, direction);
			break;
		case "W" :
				x =x- 1;
				position =  new Position(x, y, direction);
			break;
		}
		
		// Ne rien faire si la tondeuse se retrouve en dehors du terrain	
		return position;
		
	}
	
	
	/*public Position avancer(final Pelouse pelouse){
		// Ne marchera que sur jvm >= 1.7
		Position position = this;
		
		switch(direction.toString()){
		case  "N" :
			if (y < pelouse.getySupD()) {
				y =y+1;
				position= new Position(x, y, direction);
			}
			break;
		case "S" :
			if (y > 0) {
				y = y-1;
				position = new Position(x, y, direction);
			}
			break;
		case "E" :
			if (x < pelouse.getxSupD()) {
				x =x+ 1;
				position =  new Position(x, y, direction);
			}
			break;
		case "W" :
			if (x > 0) {
				x =x- 1;
				position =  new Position(x, y, direction);
			}
			break;
		}
		
		// Ne rien faire si la tondeuse se retrouve en dehors du terrain	
		return position;
		
	}
	 * 
	 * */
	
	
	/**
	 * 
	 * @param pelouse pelouse sur laquelle on veut faire avancer la tondeuse
	 * @return vrai ou faux selon que la dondeuse puisse avancer ou pas.
	 */
	public boolean peutAvancer(final Pelouse pelouse){
		boolean peutAvancer = false;
		int xSup = pelouse.getxSupD();
		int ySup = pelouse.getySupD();
				
		if ((direction.getOrientation().equals(Direction.Nord)) && (y<ySup)){
			peutAvancer = true;
		}
		else if ((direction.getOrientation().equals(Direction.Sud))&& (y>0)){
			peutAvancer = true;
		}
		else if ((direction.getOrientation().equals(Direction.Est))&& (x<xSup)){
			peutAvancer = true;
		}
		else if ((direction.getOrientation().equals(Direction.Ouest))&& (x>0)){
			peutAvancer = true;
		}
		
		return peutAvancer;
	}

	
}

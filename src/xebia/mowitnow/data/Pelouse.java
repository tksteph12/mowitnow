package mowitnow.data;

/**
 * @author Stephane TATCHUM
 *
 */
public class Pelouse {
	private int xSupD;
	private int ySupD;
	public Pelouse(final int xSupD, final int ySupD){
		this.xSupD = xSupD;
		this.ySupD  = ySupD;
	}
	
	public Pelouse(final String ligneFichier){
		String[] coords = ligneFichier.split(" ");
		assert(coords.length==2): "The length of this array should be 2";
		xSupD = Integer.parseInt(coords[0]);
		ySupD = Integer.parseInt(coords[1]);
		
	}
	
	/**
	 * @return the xSupD
	 */
	public int getxSupD() {
		return xSupD;
	}

	/**
	 * @return the ySupD
	 */
	public int getySupD() {
		return ySupD;
	}
}

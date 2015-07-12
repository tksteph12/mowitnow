
package mowitnow;

import java.util.ArrayList;
import java.util.List;

import mowitnow.data.Pelouse;
import mowitnow.data.Position;
import mowitnow.data.Tondeuse;
import mowitnow.exception.InvalidInstructionException;
import mowitnow.exception.InvalidPositionException;
import mowitnow.utils.Helpers;

/**
 * @author Stephane TATCHUM
 *
 */
public class Controle {
	
	/**
	 * 
	 * @param instructions : Liste contenant en première position les limites de la pelouse, et les tondeuses sur les autres positions
	 * 		   pour k>=0 Position 2k+1 ==> instruction pour la position initiale de la tondeuse
	 * 					 Position 2k+2 ==> instructions poru le déplacement de la tondeuse en position précedente  
	 * @throws InvalidInstructionException 
	 */
	public List<Position> executerTondeuses(List<String> instructions) throws InvalidInstructionException,InvalidPositionException{
		List positionsFinale = new ArrayList<Position>();
		Position positionFinale ;
		//assert((instructions.size()%2)==1):"the number of lines in the initial file should be odd";
		  int nbTondeuses = (instructions.size()-1)/2;
		  //La premiere case de la liste represente les limites de la pelouse.
		  Pelouse pelouse = new Pelouse(instructions.get(0));
		  for(int k=0; k <nbTondeuses;k++){
			  Position position = new Position(instructions.get(2*k+1));
			  if(position.getX()>pelouse.getxSupD() || position.getY()>pelouse.getySupD()){
				  throw new InvalidPositionException("La Tondeuse No:"+ (k+1) +" est en dehors de la pelouse");
			  }
			  Tondeuse tondeuse = new Tondeuse(position, pelouse);
			  positionFinale = tondeuse.executerSequence(Helpers.convertSequenceToList(instructions.get(2*k+2)));
			  positionsFinale.add(positionFinale);
//			  System.out.println("Tondeuse No"+(k+1));
			  System.out.println(positionFinale.getX() + " "+ positionFinale.getY()+" "+ positionFinale.getDirection().getOrientation());

		  }
		return positionsFinale;
	}
	
	
	
	
}

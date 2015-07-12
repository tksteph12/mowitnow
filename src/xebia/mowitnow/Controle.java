
package mowitnow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mowitnow.data.Pelouse;
import mowitnow.data.Position;
import mowitnow.data.Tondeuse;
import mowitnow.exception.InvalidDirectionException;
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
	 * @param instructions : Liste d'instructions 
	 * @throws InvalidInstructionException 
	 */
	public void executerTondeuses(List<String> instructions) throws InvalidInstructionException{
		assert((instructions.size()%2)==1):"the number of lines in the initial file should be odd";
		  int nbTondeuses = (instructions.size()-1)/2;
		  //La premiere case de la liste represente les limites de la pelouse.
		  Pelouse pelouse = new Pelouse(instructions.get(0));
		  for(int k=0; k <nbTondeuses;k++){
			  Position position = new Position(instructions.get(2*k+1));
			  Tondeuse tondeuse = new Tondeuse(position, pelouse);
			  tondeuse.executerSequence(Helpers.convertSequenceToList(instructions.get(2*k+2)));
		  }
		
	}
	
	
	
	
}

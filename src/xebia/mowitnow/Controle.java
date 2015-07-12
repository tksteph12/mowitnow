
package mowitnow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	private Map<Tondeuse,String> tondeuses;
	
	public  Map<Tondeuse,String> parcourirFichier(File input) throws FileNotFoundException,IOException{
		tondeuses =  Helpers.getAllTondeusesFromFile(input);
		return tondeuses;
	}
	
	public void executer() throws InvalidPositionException,InvalidDirectionException,InvalidInstructionException{
		Set keys = tondeuses.keySet();
		Iterator iterator = keys.iterator();
		int i =0;
		while(iterator.hasNext()){
			System.out.println("Execution tondeuse no : "+ i++);
			Tondeuse tondeuse = (Tondeuse) iterator.next();
			String instructions = tondeuses.get(tondeuse);
			List<Character> sequenceTondeuse = Helpers.convertSequenceToList(instructions);
			tondeuse.executerSequence(sequenceTondeuse);
		}
	}
}

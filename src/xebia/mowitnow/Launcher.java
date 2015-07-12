package mowitnow;

import java.io.File;
import java.util.List;

import mowitnow.data.Position;

/**
 * @author Stephane TATCHUM
 *
 */
public class Launcher {
/**
 * Lancement d'une tondeuse 
 * @param args
 */
	public static void main(String [] args){
		String fileName = args[0];
		// fichier en entréee
		File input = new File(fileName);
		//positions parcourues par les tondeuses si plusieurs
		List<Position> positions = Controle.parcourir(input);
		
	}
	
}

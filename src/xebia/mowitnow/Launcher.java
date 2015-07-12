package mowitnow;

import java.io.File;
import java.io.IOException;
import java.util.List;

import mowitnow.data.Position;
import mowitnow.exception.FichierMalFormeException;
import mowitnow.exception.InvalidInstructionException;
import mowitnow.utils.Helpers;

/**
 * @author Stephane TATCHUM
 *
 */
public class Launcher {
/**
 * Lancement d'une tondeuse 
 * @param args
 */
	public static void main(String[] args){
		try {
			List<String> instructions = Helpers.analysePath("src/ressources/tondeuses.txt");
			System.out.println(instructions);
			Controle controle = new Controle();
			controle.executerTondeuses(instructions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FichierMalFormeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidInstructionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

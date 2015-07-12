package mowitnow;

import java.io.File;
import java.io.IOException;
import java.util.List;

import mowitnow.data.Position;
import mowitnow.exception.FichierMalFormeException;
import mowitnow.exception.InvalidInstructionException;
import mowitnow.exception.InvalidPositionException;
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
			Controle controle = new Controle();
			controle.executerTondeuses(instructions);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (FichierMalFormeException e) {
			System.out.println(e.getMessage());
		} catch (InvalidInstructionException e) {
			System.out.println(e.getMessage());
		} catch (InvalidPositionException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

package mowitnow.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mowitnow.data.Tondeuse;

/**
 * @author Stephane TATCHUM
 *Classe utilitaire par exemple pour la lecture de fichiers
 */
public class Helpers {
	
	/**
	 * Convertit une chainne de caract�re en une liste de caract�res
	 * @param sequence : chainne de caract�re en entr�e
	 * @return une liste de caractr�res
	 */
	public static List<Character> convertSequenceToList(String sequence){
		List<Character> list = new ArrayList<Character>();
		char[] charSequence = sequence.toCharArray();
		for(char c : charSequence) {
			list.add(c);
		}
		return list;
	}
	
	/*Pour la version finale limite le couplage entre les packages en sortans la tondeuse de cette classe
	 * trouver la structure de donn�es adapt�e
	 * */
	public static Map<Tondeuse,String> getAllTondeusesFromFile(File input){
		
		return null;
	}
	
	

	
}

package mowitnow.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mowitnow.data.Tondeuse;
import mowitnow.exception.FichierMalFormeException;

/**
 * @author Stephane TATCHUM
 *Classe utilitaire par exemple pour la lecture de fichiers
 */
public class Helpers {
	
	/**
	 * Convertit une chainne de caractère en une liste de caractères
	 * @param sequence : chainne de caractère en entrée
	 * @return une liste de caractrères
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
	 * trouver la structure de données adaptée
	 * Il faudra redéfinir equals  & Hashcode pour l'objet Tondeuse
	 * */
	public static Map<Tondeuse,String> getAllTondeusesFromFile(File input){
		
		return null;
	}
	
	
	public static List<String> analysePath(String filePath) throws IOException, FichierMalFormeException{
		List<String> instructions = new ArrayList<>();
		File instFile = new File(filePath);
		FileReader fileReader;
		fileReader = new FileReader(instFile);
		BufferedReader buffer= new BufferedReader(fileReader);
		String line;
		while((line=buffer.readLine())!=null){
			if(!(line.trim().isEmpty()))
				instructions.add(line);
		}
		return instructions;
	}
	
	
	
	

	
}

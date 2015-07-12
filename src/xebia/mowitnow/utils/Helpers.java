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
	 * Il faudra red�finir equals  & Hashcode pour l'objet Tondeuse
	 * */
	public static Map<Tondeuse,String> getAllTondeusesFromFile(File input){
		
		return null;
	}
	
	/**
	 * 
	 * @param filePath chemin relatif du fichier source alimentant le programme
	 * @return Liste contenant en premi�re position les limites de la pelouse, et les tondeuses sur les autres positions
	 * 		   pour k>=0 Position 2k+1 ==> instruction pour la position initiale de la tondeuse
	 * 					 Position 2k+2 ==> instructions poru le d�placement de la tondeuse en position pr�cedente  
	 * @throws IOException
	 * @throws FichierMalFormeException
	 */
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
		if(!((instructions.size()%2)==1)){
			throw new FichierMalFormeException(" Fichier Malform�: Le fichier doit contenir un nombre Impair de lignes");
		}
		return instructions;
	}
	
	
	
	

	
}

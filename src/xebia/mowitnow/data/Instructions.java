package mowitnow.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stephane TATCHUM
 * Cette classe définit les instructions à envoyer à la tondeuse
 */
public class Instructions {
	public final static String AVANCE = "A";
	public final static String  GAUCHE = "G";
	public final static String DROITE = "D";
	
	public static Map<String, String> instructions = null;
	static {
		Map<String, String> myInstructions =new HashMap<String, String>() ;
		myInstructions.put(Instructions.AVANCE, "A");
		myInstructions.put(Instructions.GAUCHE, "G");
		myInstructions.put(Instructions.DROITE, "D");
		instructions = Collections.unmodifiableMap(myInstructions);
    }
	
}

package mowitnow.data;

import java.util.ArrayList;
import java.util.List;

import mowitnow.exception.InvalidInstructionException;

//import main.java.foo.*;

/**
 * @author Stephane TATCHUM
 *
 */
public class Test {

	public static void main(String [] args){
		
		Direction dir = new Direction('N');
		System.out.println(dir);
//		System.out.println("Position de gauche :"+dir.gauche());
//		System.out.println("Position de droite :"+dir.droite());
		Pelouse pelouse = new Pelouse();
		pelouse.initialiserPelouse(5, 5);
		Position pos = new Position(1, 2, dir);
//		System.out.println(pos.peutAvancer(pelouse));
		
		String ins = "GAFAGAGAA";
		char[] instruction = ins.toCharArray();
		List<Character> instructions = new ArrayList<Character>();
		for(char c : instruction) {
			instructions.add(c);
		}
		//kk.toCharArray()
		Tondeuse tondeuse = new Tondeuse(pos,pelouse);
		Position positionFinale = null;
		try {
			positionFinale = tondeuse.executerSequence(instructions);
		} catch (InvalidInstructionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(positionFinale.getX() + " "+ positionFinale.getY()+" "+ positionFinale.getDirection());
		
/*		
		Direction dir = new Direction('E');
		System.out.println(dir);
//		System.out.println("Position de gauche :"+dir.gauche());
//		System.out.println("Position de droite :"+dir.droite());
		Pelouse pelouse = new Pelouse();
		pelouse.initialiserPelouse(5, 5);
		Position pos = new Position(3, 3, dir);
//		System.out.println(pos.peutAvancer(pelouse));
		
		String ins = "AADAADADDA";
		char[] instruction = ins.toCharArray();
		List<Character> instructions = new ArrayList<Character>();
		for(char c : instruction) {
			instructions.add(c);
		}
		//kk.toCharArray()
		Tondeuse tondeuse = new Tondeuse(pos,pelouse);
		Position positionFinale = tondeuse.executerSequence(instructions);
		System.out.println(positionFinale.getX() + " "+ positionFinale.getY()+" "+ positionFinale.getDirection().getOrientation());
		
*/
		
	}
}

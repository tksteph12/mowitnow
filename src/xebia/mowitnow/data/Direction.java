package mowitnow.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stephane TATCHUM
 *
 */
public final class Direction{
	//Définir les constantes directionnelles
	final static Character Nord = 'N';
	final static Character Sud = 'S';
	final static Character Est = 'E';
	final static Character Ouest = 'W';
	//orientation de l'objet
	private Character orientation;
	private Character orientationG;
	private Character orientationD;

	//sera utilisé pour  la recherche d'une direction
	private static Map<Character, Direction> directions = null;
		static {
			Map<Character, Direction> myDirections =new HashMap<Character, Direction>() ;
			myDirections.put(Direction.Nord, new Direction('N'));
			myDirections.put(Direction.Sud, new Direction('S'));
			myDirections.put(Direction.Est, new Direction('E'));
			myDirections.put(Direction.Ouest, new Direction('W'));
			directions = Collections.unmodifiableMap(myDirections);
	    }
	
	Direction(char dir){
		this.orientation = dir;
		
		switch (orientation.toString()){
			case("N"):{
				orientationG = 'W';
				orientationD = 'E';
			}
			case("S"):{
				orientationG = 'E';
				orientationD = 'W';
			}
			case("E"):{
				orientationG = 'N';
				orientationD = 'S';
			}
			case("W"):{
				orientationG = 'S';
				orientationD = 'N';
			}
		}
			
	}
	
	public  static Direction  getDirection(final Character key){
		return directions.containsKey(key)==true ? directions.get(key): null;
	}
	
	public String toString(){
		return this.orientation.toString();
	}
	
	public Direction gauche(){
		switch (this.orientation.toString()){
			case("N"):{
				return new Direction('W');
			}
			case("S"):{
				return new Direction('E');
	
			}
			case("E"):{
				return new Direction('N');
	
			}
			case("W"):{
				return new Direction('S');
	
			}
		}
		return this; 
	}
	public Direction droite(){
		switch (this.orientation.toString()){
			case("N"):{
				return new Direction('E');
			}
			case("S"):{
				return new Direction('W');
	
			}
			case("E"):{
				return new Direction('S');
	
			}
			case("W"):{
				return new Direction('N');
	
			}
		}
		return this;
	}
	public Character getOrientation(){
		return orientation;
	}

	
	/*
	 * Nord ==> (x,y+1)
	 * Sud ==> (x,y-1)
	 * Est ==> (x+1,y)
	 * Ouest ==> (x-1,y)
	 * */
	
	
}

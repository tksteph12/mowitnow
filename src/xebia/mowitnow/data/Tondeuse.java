package mowitnow.data;

import java.util.List;

import mowitnow.exception.InvalidInstructionException;


/**
 * @author Stephane TATCHUM
 *La tondeuse sera caracterisee par sa position,dans une pelouse ainsi qu'une liste d'instructions à executer
 */
public class Tondeuse {
	private Position position;
	private Pelouse pelouse;
//	private List<Character> instructions;
	
	public Tondeuse(Position position, Pelouse pelouse) {
		super();
		this.position = position;
		this.pelouse = pelouse;
	}
	
	private void deplacerTondeuse(Character instruction) {
		switch (instruction.toString()) {
			case Instructions.AVANCE :
				position.avancer(pelouse);
				break;
			case Instructions.DROITE :
				position.pivoterDroite();
				break;
 			case Instructions.GAUCHE :
 				position.pivoterGauche();
 				break;
		}
	}
	

	public Position executerSequence(List<Character> sequence) throws InvalidInstructionException{//Invalid Sequence Exception
		for(Character seq : sequence) {
			if(!Instructions.instructions.containsKey(seq.toString())){
				throw new InvalidInstructionException(seq + " Is not a valid instruction");
			}
			deplacerTondeuse(seq);
			System.out.println(position.getX() + " "+ position.getY()+" "+ position.getDirection().getOrientation());

		}
		return position;
	}
	
	}

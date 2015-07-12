package mowitnow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.file.DirectoryIteratorException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mowitnow.data.Direction;
import mowitnow.data.Pelouse;
import mowitnow.data.Position;
import mowitnow.data.Tondeuse;
import mowitnow.exception.InvalidInstructionException;
import mowitnow.exception.InvalidPositionException;

public class TestMowItNow {

	private List<String> instructions;
	private List<Position> result;
	Position finalPositionT1;
	Position finalPositionT2;
	private List<Position> resultatAttendu;
	
	@Before
	public void buildTestResults(){
		resultatAttendu = new ArrayList<Position>();
		finalPositionT1= new Position("1 3 N");
		finalPositionT2 = new Position("5 1 E");
		resultatAttendu.add(finalPositionT1);
		resultatAttendu.add(finalPositionT2);
		
		
		//Cas de test
		instructions = Arrays.asList("5 5", "1 2 N", "GAAAAAAAGAGAGAA", "3 3 E",  "AAAAAAADAADADDA");

	}
	
	
	@Test
	public void doTestParcours(){
		Controle controle = new Controle();
		try {
			result = controle.executerTondeuses(instructions);
		} catch (InvalidInstructionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(result);
		assertEquals(result.size(), resultatAttendu.size());

		//1ere tondeuse
		assertEquals(result.get(0).getX(), resultatAttendu.get(0).getX());
		assertEquals(result.get(0).getY(), resultatAttendu.get(0).getY());
		assertEquals(result.get(0).getDirection().getOrientation(), resultatAttendu.get(0).getDirection().getOrientation());
		
		
		//2e tondeuse
		assertEquals(result.get(1).getX(), resultatAttendu.get(1).getX());
		assertEquals(result.get(1).getY(), resultatAttendu.get(1).getY());
		assertEquals(result.get(1).getDirection().getOrientation(), resultatAttendu.get(1).getDirection().getOrientation());
		

	}

}

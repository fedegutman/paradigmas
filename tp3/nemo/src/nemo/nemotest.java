package nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class Nemotest {
	
	@Test public void test00IsNemoOnSurface() {
		Nemo robot = new Nemo();
		assertEquals(robot.xcoordinate, 0);
		assertEquals(robot.ycoordinate, 0);
		assertEquals(robot.depth, 0);
		assertTrue (robot.capsule);
		assertEquals(robot.direction, "North");

	}
	
	@Test public void test01EmptyDirectionsDontMoveNemo() {
		Nemo robot = new Nemo();
		robot.changeCoordinate(" ");
		assertEquals(robot.xcoordinate, 0);
		assertEquals(robot.ycoordinate, 0);
		assertEquals(robot.depth, 0);
		assertTrue (robot.capsule);
	}
	
	@Test public void test02NemoReceivesD() {
		Nemo robot = new Nemo();
		robot.takeStep('d');
		assertEquals(robot.xcoordinate, 0);
		assertEquals(robot.ycoordinate, 0);
		assertEquals(robot.depth, -1);
		assertTrue (robot.capsule);

	}
	
	@Test public void test03NemoReceivesU() {
		Nemo robot = new Nemo();
		robot.takeStep('d');
		assertEquals(robot.xcoordinate, 0);
		assertEquals(robot.ycoordinate, 0);
		assertEquals(robot.depth, -1);
		robot.takeStep('u');
		assertEquals(robot.depth, 0);

	}

	@Test public void testNemoReceivesF() {
		Nemo robot = new Nemo();
		robot.takeStep('f');
		assertEquals(robot.xcoordinate, 0);
		assertEquals(robot.ycoordinate, 1);
		assertEquals(robot.depth, 0);

	}
	
	@Test public void test04NemoReceivesL() {
		Nemo robot = new Nemo();
		robot.takeStep('l');
		assertEquals(robot.xcoordinate, 0);
		assertEquals(robot.ycoordinate, 0);
		assertEquals(robot.direction, "West");
		
	}
	
	@Test public void test05NemoReceivesR() {
		Nemo robot = new Nemo();
		robot.takeStep('r');
		assertEquals(robot.xcoordinate, 0);
		assertEquals(robot.ycoordinate, 0);
		assertEquals(robot.direction, "East");
		
	}
	
	@Test public void test06NemoReceivesString() {
		Nemo robot = new Nemo();
		robot.changeCoordinate("rl");
		assertEquals(robot.direction, "North");
		
	}
	
	@Test public void test07NemoReceivesStrings() {
		Nemo robot = new Nemo();
		robot.changeCoordinate("rlfrfflf");
		assertEquals(robot.direction, "North");
		assertEquals(robot.xcoordinate, 2);
		assertEquals(robot.ycoordinate, 2);
		
		
	}
	
	@Test public void testcapsule08True() {
		Nemo robot = new Nemo();
		robot.changeCoordinate("dm");
		assertTrue(robot.capsule);
		assertEquals(-1,robot.depth);
		
		
		
	}
	
	@Test public void testcapsule09False() {
		Nemo robot = new Nemo();
		robot.changeCoordinate("ddm");
		assertFalse(robot.capsule);
		
		
		
		
	}
}

/*
test 00 
-> esta en la superficie?
-> en que posicion esta?
-> para donde esta mirando?

test 01
-> 'lrfdum' (coordenadas que va a leer mas adelante)
-> le paso ""
-> no hace nada (no se tiene que mover)

test 02
-> recibo solo un d

test 03
-> recibo solo un u

test 04
->

test 05 
->

*/
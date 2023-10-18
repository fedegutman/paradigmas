package nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class nemotest {
	
	@Test public void test00IsNemoOnSurface() {
		Nemo nemo = new Nemo();
		assertEquals(nemo.getCoordinates(), new Coordinates(0,0));
		assertEquals(nemo.getDirection(), new North());
		assertEquals(nemo.depth, 0);

	}
	
//	@Test public void test01EmptyDirectionsDontMoveNemo() {
//		Nemo robot = new Nemo();
//		robot.changeCoordinate(" ");
//		assertEquals(robot.xcoordinate, 0);
//		assertEquals(robot.ycoordinate, 0);
//		assertEquals(robot.depth, 0);
//
//	}
//	
//	@Test public void test02NemoReceivesD() {
//		Nemo robot = new Nemo();
//		robot.takeStep('d');
//		assertEquals(robot.xcoordinate, 0);
//		assertEquals(robot.ycoordinate, 0);
//		assertEquals(robot.depth, -1);
//
//	}
//	
//	@Test public void test03NemoReceivesU() {
//		Nemo robot = new Nemo();
//		robot.takeStep('d');
//		assertEquals(robot.xcoordinate, 0);
//		assertEquals(robot.ycoordinate, 0);
//		assertEquals(robot.depth, -1);
//		robot.takeStep('u');
//		assertEquals(robot.depth, 0);
//
//	}
//	
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
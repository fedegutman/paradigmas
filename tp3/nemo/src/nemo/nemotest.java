package nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class Nemotest {
	private static final String Explosion = "Submarine Explosion";

	
	@Test public void test00IsNemoOnSurface() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North() );
		assertEquals(nemo.getCoordinates(), new Coordinates(0,0));
		assertEquals(nemo.getDirection(), new North());
		assertEquals(nemo.profundidad(), 0);

	}
	
	@Test public void test02nemoRecivesNothing() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("");
		assertEquals(nemo.getCoordinates(), new Coordinates(0,0));
		assertEquals(nemo.getDirection(), new North());
		assertEquals(nemo.profundidad(), 0);

		

	}
	
	@Test public void test03nemoRecivesR() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("r");
		assertEquals(nemo.getCoordinates(), new Coordinates(0,0));
		assertEquals(nemo.getDirection(), new East());
		assertEquals(nemo.profundidad(), 0);

		

	}
	
	@Test public void test04nemoRecivesl() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("l");
		assertEquals(nemo.getCoordinates(), new Coordinates(0,0));
		assertEquals(nemo.getDirection(), new West());
		assertEquals(nemo.profundidad(), 0);

		

	}
	
	@Test public void test05nemoRecivesLL() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("ll");
		assertEquals(nemo.getCoordinates(), new Coordinates(0,0));
		assertEquals(nemo.getDirection(), new South());
		assertEquals(nemo.profundidad(), 0);

		

	}
	
	@Test public void test06nemoRecivesD() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("d");
		assertEquals(nemo.getCoordinates(), new Coordinates(0,0));
		assertEquals(nemo.getDirection(), new North());
		assertEquals(nemo.profundidad(),-1);
		

	}
	
	@Test public void test07nemoRecivesU() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("du");
		assertEquals(nemo.getCoordinates(), new Coordinates(0,0));
		assertEquals(nemo.getDirection(), new North());
		assertEquals(nemo.profundidad(),0);

		

	}
	
	@Test public void test08nemoReleaseCapsuleAndExplodes() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
        assertEquals(assertThrows(Error.class, () -> nemo.move("ddm")).getMessage(), Explosion);

	}
	
	
	@Test public void test09nemoRecivesLargeString() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("dllfrrfmflrddu");
		assertEquals(nemo.getCoordinates(), new Coordinates(0,1));
		assertEquals(nemo.getDirection(), new North());
		assertEquals(nemo.profundidad(),-2);	

	}
	
	@Test public void test09nemoRecivesLargeStringAndExplodes() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
        assertEquals(assertThrows(Error.class, () -> nemo.move("dllfrrfflrddum")).getMessage(), Explosion);

	}

}


	
//	@Test public void test01EmptyDirectionsDontMoveNemo() {
//		Nemo robot = new Nemo();
//		robot.changeCoordinate(" ");
//		assertEquals(robot.xcoordinate, 0);
//		assertEquals(robot.ycoordinate, 0);
//		assertEquals(robot.depth, 0);
//		assertTrue (robot.capsule);
//	}
//	
//	@Test public void test02NemoReceivesD() {
//		Nemo robot = new Nemo();
//		robot.takeStep('d');
//		assertEquals(robot.xcoordinate, 0);
//		assertEquals(robot.ycoordinate, 0);
//		assertEquals(robot.depth, -1);
//		assertTrue (robot.capsule);
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
//	@Test public void test04NemoReceivesL() {
//		Nemo robot = new Nemo();
//		robot.takeStep('l');
//		assertEquals(robot.xcoordinate, 0);
//		assertEquals(robot.ycoordinate, 0);
//		assertEquals(robot.direction, "West");
//		
//	}
//	
//	@Test public void test05NemoReceivesR() {
//		Nemo robot = new Nemo();
//		robot.takeStep('r');
//		assertEquals(robot.xcoordinate, 0);
//		assertEquals(robot.ycoordinate, 0);
//		assertEquals(robot.direction, "East");
//		
//	}
//	
//	@Test public void test06NemoReceivesString() {
//		Nemo robot = new Nemo();
//		robot.changeCoordinate("rl");
//		assertEquals(robot.direction, "North");
//		
//	}
//	
//	@Test public void test07NemoReceivesStrings() {
//		Nemo robot = new Nemo();
//		robot.changeCoordinate("rlfrfflf");
//		assertEquals(robot.direction, "North");
//		assertEquals(robot.xcoordinate, 2);
//		assertEquals(robot.ycoordinate, 2);
//		
//		
//	}
//	
//	@Test public void testcapsule08True() {
//		Nemo robot = new Nemo();
//		robot.changeCoordinate("dm");
//		assertTrue(robot.capsule);
//		assertEquals(-1,robot.depth);
//		
//		
//		
//	}
//	
//	@Test public void testcapsule09False() {
//		Nemo robot = new Nemo();
//		robot.changeCoordinate("ddm");
//		assertFalse(robot.capsule);
//		
//		
//		
//		
//	}
//}
//
///*
//test 00 
//-> esta en la superficie?
//-> en que posicion esta?
//-> para donde esta mirando?
//
//test 01
//-> 'lrfdum' (coordenadas que va a leer mas adelante)
//-> le paso ""
//-> no hace nada (no se tiene que mover)
//
//test 02
//-> recibo solo un d
//
//test 03
//-> recibo solo un u
//
//test 04
//->
//
//test 05 
//->
//
//*/
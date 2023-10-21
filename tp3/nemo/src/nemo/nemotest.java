package nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class Nemotest {
	private static final String Explosion = "Submarine Explosion";

	
	@Test public void test00NemoOnSurface() {
		comparePositions(new Coordinates(0,0),new North(),0,new Nemo(new Coordinates (0,0), new North() ));
	}

	
	
	@Test public void test01nemoRecivesNothing() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("");
		comparePositions(new Coordinates(0,0),new North(),0,nemo);

	}
	
	@Test public void test02nemoRecivesF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("f");
		comparePositions(new Coordinates(0,1),new North(),0,nemo);

	}
	
	@Test public void test03nemoRecivesRF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("rf");
		comparePositions(new Coordinates(1,0),new East(),0,nemo);

	}
	
	@Test public void test04nemoRecivesRRF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("rrf");
		comparePositions(new Coordinates(0,-1),new South(),0,nemo);

	}
	
	@Test public void test05nemoRecivesRRRF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("rrrf");
		comparePositions(new Coordinates(-1,0),new West(),0,nemo);


	}
	
	@Test public void test06nemoRecivesRRRRF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("rrrrf");
		comparePositions(new Coordinates(0,1),new North(),0,nemo);

		

	}
	
	@Test public void test07nemoRecivesLF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("lf");
		comparePositions(new Coordinates(-1,0),new West(),0,nemo);
	}
	
	@Test public void test08nemoRecivesLLF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("llf");
		comparePositions(new Coordinates(0,-1),new South(),0,nemo);	

	}
	
	@Test public void test09nemoRecivesLLLF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("lllf");
		comparePositions(new Coordinates(1,0),new East(),0,nemo);

	}
	
	@Test public void test10nemoRecivesLLLLF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("llllf");
		comparePositions(new Coordinates(0,1),new North(),0,nemo);	
	}
	
	
	@Test public void test11nemoRecivesD() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("d");
		comparePositions(new Coordinates(0,0),new North(),-1,nemo);
		

	}
	
	@Test public void test12nemoRecivesU() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("du");
		comparePositions(new Coordinates(0,0),new North(),0,nemo);

	}
	
	@Test public void test13nemoReleaseCapsuleAndExplodes() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		assertThrowsLike(() -> nemo.move("ddm"),nemo);

	}
	
	
	@Test public void test14nemoRecivesLargeString() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("dllfrrfmflrddu");
		comparePositions(new Coordinates(0,1),new North(),-2,nemo);	

	}
	
	@Test public void test15nemoRecivesLargeStringAndExplodes() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
        assertThrowsLike(() -> nemo.move("dllfrrfflrddum"),nemo);

	}

	
	@Test public void test16nemoGoesDeepAndComesBackAndReleaseCapsule() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("ddduum");
		comparePositions(new Coordinates(0,0),new North(),-1,nemo);	

	}
	
	@Test public void test17checkDepth() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		nemo.move("dddddddddduuud");
		comparePositions(new Coordinates(0,0),new North(),-8,nemo);	

	}
	

	
	private void comparePositions(Coordinates coordinates,Direction direction,int profundidad, Nemo nemo) {
		assertEquals(nemo.getCoordinates(), coordinates);
		assertEquals(nemo.getDirection(), direction);
		assertEquals(nemo.profundidad(), profundidad);
	}
	
	private void assertThrowsLike(Executable executable,Nemo nemo) {
		assertEquals(assertThrows(Error.class, executable).getMessage(), Explosion);
	}
	
}


	

	
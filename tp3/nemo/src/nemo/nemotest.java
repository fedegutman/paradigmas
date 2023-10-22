package nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class NemoTest {
	private static final String Explosion = "Submarine Explosion";
	
	@Test public void test00NemoOnSurface() {
		comparePositions(new Coordinates(0,0), new North(), 0, new Nemo(new Coordinates (0,0), new North() ));
	}

	@Test public void test01NemoReceivesNothing() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(0,0), new North(), 0, nemo.move(""));
	}
	
	@Test public void test02NemoReceivesF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(0,1), new North(), 0, nemo.move("f"));
	}
	
	@Test public void test03NemoReceivesRF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(1,0), new East(), 0, nemo.move("rf"));
	}
	
	@Test public void test04NemoReceivesRRF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(0,-1), new South(), 0, nemo.move("rrf"));
	}
	
	@Test public void test05NemoReceivesRRRF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(-1,0), new West(), 0, nemo.move("rrrf"));
	}
	
	@Test public void test06NemoReceivesRRRRF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(0,1), new North(), 0, nemo.move("rrrrf"));
	}
	
	@Test public void test07NemoStartsInOtherPositionAndReceivesF() {
		Nemo nemo = new Nemo(new Coordinates (0,-1), new North());
		comparePositions(new Coordinates(0,0), new North(), 0, nemo.move("f"));	
	}
	
	@Test public void test08NemoReceivesLF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(-1,0), new West(), 0, nemo.move("lf"));
	}
	
	@Test public void test09NemoReceivesLLF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(0,-1), new South(), 0, nemo.move("llf"));	
	}
	
	@Test public void test10NemoReceivesLLLF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(1,0), new East(), 0, nemo.move("lllf"));
	}
	
	@Test public void test11NemoReceivesLLLLF() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(0,1), new North(), 0, nemo.move("llllf"));	
	}
	
	@Test public void test12NemoReceivesD() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(0,0), new North(), -1, nemo.move("d"));
	}
	
	@Test public void test13NemoReceivesDU() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(0,0), new North(), 0, nemo.move("du"));
	}
	
	@Test public void test14NemoReleasesCapsuleAndExplodes() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		assertThrowsLike(() -> nemo.move("ddm"), Explosion);
	}
	
	@Test public void test15NemoReceivesLargeString() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(-3,5), new West(), -7, nemo.move("dllfrrfmflrddufffffldlrffddrldlfdlrrf"));	
	}
	
	@Test public void test16NemoReceivesLargeStringAndExplodes() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
        assertThrowsLike(() -> nemo.move("dllfrrfflrddum"), Explosion);
	}

	@Test public void test17NemoGoesDeepAndComesBackAndReleaseCapsule() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(0,0), new North(), -1, nemo.move("ddduum"));	
	}
	
	@Test public void test18CheckDepthWorksCorrectly() {
		Nemo nemo = new Nemo(new Coordinates (0,0), new North());
		comparePositions(new Coordinates(0,0), new North(), -8, nemo.move("dddddddddduuud"));	
	}
		
	private void comparePositions(Coordinates coordinates, Direction direction, int depth, Nemo nemo) {
		assertEquals(nemo.getCoordinates(), coordinates);
		assertEquals(nemo.getDirection(), direction);
		assertEquals(nemo.profundidad(), depth);
	}
	
    private void assertThrowsLike( Executable executable, String message ) {
	    assertEquals( message,
	                  assertThrows( Error.class, executable ).getMessage() );
	}
}	
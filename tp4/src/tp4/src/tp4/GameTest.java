package tp4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class GameTest {

	@Test
	public void test01() {
	Linea game = new Linea(4,4,'a');
	assertEquals(4,game.base);
	assertEquals(game.turno,new RedJuega(game));
	assertEquals(game.modoJuego, new TypeA());
	}
	
	@Test
	public void test02() {
		Linea game = new Linea(4,4,'a');
		game.playRedkAt(1);
		assertEquals(game.getItem(1,1), new RedFicha());
		assertEquals(game.turno,new BlueJuega(game));

	}
	
	@Test
	public void test03() {
		Linea game = new Linea(4,4,'a');
		game.playRedkAt(1);
		game.playBlueAt(1);
		assertEquals(game.getItem(1,1), new RedFicha());
		assertEquals(game.getItem(1,2), new BlueFicha());
		assertEquals(game.turno, new RedJuega(game));
		game.playRedkAt(4);
		assertEquals(game.getItem(4,1), new RedFicha());
		assertEquals(game.turno,new BlueJuega(game));

	}
	@Test
	public void test04() {
		Linea game = new Linea(4,9,'a');
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(2);

		assertThrowsLike(() -> game.playRedkAt(1), "Ganaste bro");
		
	}
	@Test
	public void test05() {
		Linea game = new Linea(4,9,'a');
		game.playRedkAt(1);
		game.playBlueAt(1);
		game.playRedkAt(2);
		game.playBlueAt(2);
		game.playRedkAt(3);
		game.playBlueAt(3);
		

		assertThrowsLike(() -> game.playRedkAt(4), "Ganaste bro"); 
	}
	
	@Test
	public void test06() {
	    Linea game = new Linea(7, 9, 'b');
	    game.playRedkAt(1);
	    game.playBlueAt(2);
	    game.playRedkAt(2);
	    game.playBlueAt(3);
	    game.playRedkAt(3);
	    game.playBlueAt(4);
	    game.playRedkAt(3);
	    game.playBlueAt(4);
	    game.playRedkAt(4);
	    game.playBlueAt(1);

		assertThrowsLike(() -> game.playRedkAt(4), "Ganaste bro"); 
	}
	
	@Test
	public void test07() {
	    Linea game = new Linea(7, 9, 'b');
	    game.playRedkAt(1);
	    game.playBlueAt(1);
	    game.playRedkAt(1);
	    game.playBlueAt(1);
	    game.playRedkAt(2);
	    game.playBlueAt(2);
	    game.playRedkAt(3);
	    game.playBlueAt(2);
	    game.playRedkAt(1);
	    game.playBlueAt(3);
	    game.playRedkAt(1);
		assertThrowsLike(() -> game.playBlueAt(4), "Ganaste bro"); 

	}
	
	@Test
	public void test08() {
	    Linea game = new Linea(7, 9, 'c');
	    game.playRedkAt(1);
	    game.playBlueAt(2);
	    game.playRedkAt(3);
	    game.playBlueAt(5);
	    game.playRedkAt(2);
	    game.playBlueAt(3);
	    game.playRedkAt(7);
	    game.playBlueAt(5);
	    game.playRedkAt(6);
	    game.playBlueAt(3);
	    game.playRedkAt(4);
	    game.playBlueAt(3);
	    game.playRedkAt(2);
	    game.playBlueAt(7);
	    game.playRedkAt(6);
	    game.playBlueAt(1);
	    game.playRedkAt(2);
	    game.playBlueAt(1);
	    game.playRedkAt(3);
	    game.playBlueAt(2);
	    game.playRedkAt(4);
		assertThrowsLike(() -> game.playBlueAt(4), "Ganaste bro");
		
	System.out.println(game.show());}
	
		
		@Test
		public void test09() {
			Linea game = new Linea(3, 3, 'a');
			System.out.println(game.show());
			
			game.playRedkAt(1);
			assertEquals(game.getItem(1, 1), new RedFicha());
			
			game.playBlueAt(1);
			assertEquals(game.getItem(1, 2), new BlueFicha());
			
			game.playRedkAt(1);
			assertEquals(game.getItem(1, 3), new RedFicha());
			
			System.out.println(game.show());
			
			game.playBlueAt(2);
			assertEquals(game.getItem(2, 1), new BlueFicha());
					
			System.out.println(game.show());
		

	    
	
		
	}
	
	

	
	private void assertThrowsLike(Executable lambda, String message) {
		assertEquals(message, assertThrows(RuntimeException.class, lambda).getMessage());
	}
}

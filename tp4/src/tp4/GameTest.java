package tp4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class GameTest {

	private static final String TheGameEndsInADraw = "The game ends in a draw";
	private static final String RedIstheWinner= "Red is the winner";
	private static final String BlueIsTheWinner = "Blue is the winner";




	@Test
	public void test01aGameIsInitializedCorrectly() {
	Linea game = new Linea(4,4,'A');
	assertEquals(4,game.base);
	assertEquals(game.turno,new RedJuega(game));
	assertEquals(game.modoJuego, new TypeA());
	System.out.println(game.show());

	}
	
	@Test
	public void test01bAfterFirstMoveGameWorksCorrectly() {
		Linea game = new Linea(4,4,'A');
		game.playRedkAt(1);
		assertEquals(game.getItem(1,1), new RedFicha());
		assertEquals(game.turno,new BlueJuega(game));
		System.out.println(game.show());


	}
	
	@Test
	public void test01cAfterManyMovesGameWorksCorrectly() {
		Linea game = new Linea(4,4,'A');
		game.playRedkAt(1);
		game.playBlueAt(1);
		assertEquals(game.getItem(1,1), new RedFicha());
		assertEquals(game.getItem(1,2), new BlueFicha());
		assertEquals(game.turno, new RedJuega(game));
		game.playRedkAt(4);
		assertEquals(game.getItem(4,1), new RedFicha());
		assertEquals(game.turno,new BlueJuega(game));
		System.out.println(game.show());


	}
	@Test
	public void test02aRedIsVerticalWinner() {
		Linea game = new Linea(4,4,'A');
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(2);

		assertThrowsLike(() -> game.playRedkAt(1), RedIstheWinner);
		System.out.println(game.show());

		
	}
	@Test
	public void test02bBlueIsVerticalWinner() {
		Linea game = new Linea(4,9,'A');
		game.playRedkAt(4);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);

		assertThrowsLike(() -> game.playBlueAt(2), BlueIsTheWinner);
		System.out.println(game.show());

	}
	
	
	@Test
	public void test03aRedIsHorizontalWinner() {
		Linea game = new Linea(4,9,'A');
		game.playRedkAt(1);
		game.playBlueAt(1);
		game.playRedkAt(2);
		game.playBlueAt(2);
		game.playRedkAt(3);
		game.playBlueAt(3);
		

		assertThrowsLike(() -> game.playRedkAt(4), RedIstheWinner); 
		System.out.println(game.show());

	}
	@Test
	public void test03bBlueIsHorizontalWinner() {
		Linea game = new Linea(5,9,'A');
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(3);
		game.playRedkAt(2);
		game.playBlueAt(4);
		game.playRedkAt(2);
	
		assertThrowsLike(() -> game.playBlueAt(5), BlueIsTheWinner); 
		
		System.out.println(game.show());
	}
	
	@Test
	public void test04aRedIsDiagonalRightWinner() {
	    Linea game = new Linea(7, 9, 'B');
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

		assertThrowsLike(() -> game.playRedkAt(4), RedIstheWinner); 
		System.out.println(game.show());

	}
	
	@Test
	public void test04bBlueIsDiagonalRightWinner() {
	    Linea game = new Linea(7, 9, 'B');
	    game.playRedkAt(2);
	    game.playBlueAt(1);
	    game.playRedkAt(3);
	    game.playBlueAt(2);
	    game.playRedkAt(3);
	    game.playBlueAt(3);
	    game.playRedkAt(4);
	    game.playBlueAt(4);
	    game.playRedkAt(4);

		assertThrowsLike(() -> game.playBlueAt(4), BlueIsTheWinner); 
		System.out.println(game.show());

	}
	
	@Test
	public void test05aRedIsDiagonalLeftWinner() {
	    Linea game = new Linea(7, 9, 'B');
	    game.playRedkAt(4);
	    game.playBlueAt(3);
	    game.playRedkAt(3);
	    game.playBlueAt(2);
	    game.playRedkAt(2);
	    game.playBlueAt(1);
	    game.playRedkAt(2);
	    game.playBlueAt(1);
	    game.playRedkAt(1);
	    game.playBlueAt(4);
		assertThrowsLike(() -> game.playRedkAt(1), RedIstheWinner); 

		System.out.println(game.show());

	}
	
	@Test
	public void test05bBlueIsDiagonalLeftWinner() {
	    Linea game = new Linea(7, 9, 'B');
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
		assertThrowsLike(() -> game.playBlueAt(4), BlueIsTheWinner); 
		System.out.println(game.show());

	}
	
	@Test
	public void test06aDiagonalWinDoesntWorkInTypeA() {
	    Linea game = new Linea(7, 9, 'A');
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
	    game.playBlueAt(4);
	    assertFalse(game.finished);
		System.out.println(game.show());

	}
	
	@Test
	public void test06bVerticalWinDoesntWorkInTypeB() {
		Linea game = new Linea(4,9,'B');
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		assertFalse(game.finished);
		System.out.println(game.show());

	}
	@Test
	public void test06cHorizontalWinDoesntWorkInTypeB() {
	    Linea game = new Linea(7, 9, 'B');
	    game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(3);
		game.playRedkAt(2);
		game.playBlueAt(4);
		game.playRedkAt(2);
		game.playBlueAt(5);
		assertFalse(game.finished);
		System.out.println(game.show());

	}
	
	@Test
	public void test07aDiagonalWinDoesWorkInTypeC() {
	    Linea game = new Linea(7, 9, 'C');
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
		assertThrowsLike(() -> game.playBlueAt(4), BlueIsTheWinner);
	    
	}
	
	@Test
	public void test07bVerticalWinDoesWorkInTypeB() {
		Linea game = new Linea(4,5,'C');
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(2);
		assertThrowsLike(() -> game.playRedkAt(1), RedIstheWinner);

		
	}
	@Test
	public void test07cHorizontalWinDoesWorkInTypeC() {
		Linea game = new Linea(5, 6, 'C');
	    game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(1);
		game.playBlueAt(3);
		game.playRedkAt(2);
		game.playBlueAt(4);
		game.playRedkAt(2);
		assertThrowsLike(() -> game.playBlueAt(5), BlueIsTheWinner);

	}
	
	
	@Test
	public void test08aComplicatedWin() {
	    Linea game = new Linea(7, 9, 'C');
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
		assertThrowsLike(() -> game.playBlueAt(4), BlueIsTheWinner);
		System.out.println(game.show());

	}	
	
	@Test
	public void test09aDrawInTypeA() {
		Linea game = new Linea(3, 3, 'A');
	    game.playRedkAt(1);
		game.playBlueAt(1);
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(2);
		game.playBlueAt(2);
		game.playRedkAt(3);
		game.playBlueAt(3);
		assertThrowsLike(() -> game.playRedkAt(3), TheGameEndsInADraw);
	}
	
	@Test
	public void test09bDrawInTypeB() {
		Linea game = new Linea(3, 3, 'B');
	    game.playRedkAt(1);
		game.playBlueAt(1);
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(2);
		game.playBlueAt(2);
		game.playRedkAt(3);
		game.playBlueAt(3);

		assertThrowsLike(() -> game.playRedkAt(3), TheGameEndsInADraw);
	}
	
	@Test
	public void test09cDrawInTypeC() {
		Linea game = new Linea(3, 3, 'C');
	    game.playRedkAt(1);
		game.playBlueAt(1);
		game.playRedkAt(1);
		game.playBlueAt(2);
		game.playRedkAt(2);
		game.playBlueAt(2);
		game.playRedkAt(3);
		game.playBlueAt(3);
		assertThrowsLike(() -> game.playRedkAt(3), TheGameEndsInADraw);
		System.out.println(game.show());

	}
	
	@Test
	public void test10aErrors() {
		Linea game = new Linea(3, 3, 'C');
		assertThrowsLike(() -> game.playRedkAt(-1), "Invalid index: -1");
	}
	
	@Test
	public void test10bErrors() {
		Linea game = new Linea(3, 3, 'C');
		game.playRedkAt(1);
		game.playBlueAt(1);
		game.playRedkAt(1);
		assertThrowsLike(() -> game.playBlueAt(1), "Invalid index: 1");
		System.out.println(game.show());

	}
	
		
		@Test
		public void test11ShowWorksCorrectly() {
			Linea game = new Linea(3, 3, 'A');
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

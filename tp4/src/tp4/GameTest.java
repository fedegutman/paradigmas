package tp4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class GameTest {

	@Test
	public void test01() {
	Linea game = new Linea(4,4,'a');
	assertEquals(4,game.base());
	assertEquals(game.turno,new RedJuega());
	}
	
	@Test
	public void test02() {
		Linea game = new Linea(4,4,'a');
		game.playRedkAt(1);
		assertEquals(game.getItem(1,1), new RedFicha());
		assertEquals(game.turno,new BlueJuega());

	}
	
	@Test
	public void test03() {
		Linea game = new Linea(4,4,'a');
		game.playRedkAt(1);
		game.playBlueAt(1);
		assertEquals(game.getItem(1,2), new BlueFicha());
		assertEquals(game.turno,new RedJuega());
		game.playRedkAt(4);
		assertEquals(game.getItem(4,1), new RedFicha());
		assertEquals(game.turno,new BlueJuega());

	}

}

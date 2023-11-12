package tp4;

public class modo extends ModoJuego {

	@Override
	protected ModoJuego modoJuego(char c) {
		return this.cambiarModoA(c);
	}

	private ModoJuego cambiarModoA(char c) {
		return new ModoJuego.equals(c);
	}
	
	

}

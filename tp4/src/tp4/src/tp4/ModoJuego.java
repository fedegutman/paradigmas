package tp4;

import java.util.ArrayList;
import java.util.Arrays;


public abstract class ModoJuego {
	
	public static ArrayList<ModoJuego> modosJuegos = new ArrayList<>(
			Arrays.asList(
					new TypeC(), 
					new TypeB(), 
					new TypeA() )) ;
	
	
	public static ModoJuego getModoJuego(Character command) {
		return modosJuegos.stream().filter(c -> c.getModo().equals(command)).findFirst().orElse(null);
	}

	protected abstract Character getModo();

	protected abstract boolean gameWon(int x,Linea linea);

}

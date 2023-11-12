package tp4;

import java.util.Objects;

public class BlueJuega extends EstadoTurno {
	public Linea linea ;
	private String colour ;

	public BlueJuega(Linea linea) {
		this.colour="blue" ;
		this.linea=linea ;
		
	}
	
	
	
	public void juegaRojo(int x) {
		throw new Error ("No es tu turno");
	}


	public void juegaAzul(int x ) {
		linea.putBlueFicha(x);
		linea.juegaRojo();
		linea.drawGame();
		linea.gameWon(x);
//		linea.isGameWonHorizontal(x);
		
		}


	@Override
	public int hashCode() {
		return Objects.hash(colour);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlueJuega other = (BlueJuega) obj;
		return Objects.equals(colour, other.colour);
	}

	

}

package tp4;

import java.util.Objects;

public class BlueJuega extends EstadoTurno {
	public Linea linea ;
	private String player ;

	public BlueJuega(Linea linea) {
		this.player= "Blue " ;
		this.linea=linea ;
		
	}
	
	public String player() {
		return player;
	}
	
	public void juegaRojo(int x) {
		throw new Error ("No es tu turno");
	}


	public void juegaAzul(int x ) {
		linea.putBlueFicha(x);
		linea.juegaRojo();
		linea.drawGame();
		
		}


	@Override
	public int hashCode() {
		return Objects.hash(player);
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
		return Objects.equals(player, other.player);
	}

	

}

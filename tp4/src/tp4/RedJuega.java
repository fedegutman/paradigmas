package tp4;

import java.util.Objects;

public class RedJuega extends EstadoTurno {
	public Linea linea ;
	private String player ;

	public RedJuega(Linea linea) {
		this.player="Red " ;
		this.linea=linea ;
		
	}
	
	public String player() {
		return player;
	}

	
	public void juegaRojo(int x) {
		linea.putRedFicha(x);
		linea.juegaBlue();	
		linea.drawGame();

		}

	
	public void juegaAzul(int x) {
		throw new Error("No es tu turno");
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
		RedJuega other = (RedJuega) obj;
		return Objects.equals(player, other.player);
	}
	
	

	

}

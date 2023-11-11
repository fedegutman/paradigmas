package tp4;

import java.util.Objects;

public class RedJuega extends EstadoTurno {
	public Linea linea ;
	private String colour ;

	public RedJuega(Linea linea) {
		this.colour="red" ;
		this.linea=linea ;
		
	}

	
	public void juegaRojo(int x) {
		linea.putRedFicha(x);
		linea.juegaBlue();	
		linea.drawGame();
		linea.gameWon(x);
//		linea.isGameWonHorizontal(x);

		}

	
	public void juegaAzul(int x) {
		throw new Error("No es tu turno");
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
		RedJuega other = (RedJuega) obj;
		return Objects.equals(colour, other.colour);
	}
	
	

	

}

package tp4;

import java.util.Objects;

public class BlueJuega extends EstadoTurno {
	
	private String colour ;

	public BlueJuega() {
		this.colour="blue" ;
	}
	
	
	@Override
	public EstadoTurno juegaRojo() {
		throw new Error ("No es tu turno");
	}

	@Override
	public EstadoTurno juegaAzul() {
		return new RedJuega();	
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

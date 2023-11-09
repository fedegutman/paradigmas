package tp4;

import java.util.Objects;

public class RedJuega extends EstadoTurno {
	private String colour ;

	public RedJuega() {
		this.colour="red" ;
	}

	@Override
	public EstadoTurno juegaRojo() {
		return new BlueJuega();
	}

	@Override
	public EstadoTurno juegaAzul() {
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

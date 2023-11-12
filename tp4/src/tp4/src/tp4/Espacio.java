package tp4;

import java.util.Objects;

public class Espacio extends Ficha {
	
	private String colour ;
	private char character ;

	public Espacio() {
		this.colour=" " ;
		this.character= '-';
	}


	@Override
	public boolean isFichaRed() {
		return false;
	}

	@Override
	public boolean isFichaBlue() {
		return false;
	}


	@Override
	public int hashCode() {
		return Objects.hash(character, colour);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espacio other = (Espacio) obj;
		return character == other.character && Objects.equals(colour, other.colour);
	}

}

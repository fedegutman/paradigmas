package tp4;

import java.util.Objects;

public class BlueFicha extends Ficha {
	private String colour ;
	private char character ;

	public BlueFicha() {
		this.colour = "blue" ;
		this.character = 'O';
	}
	
	public boolean isFichaRed() {
		return false;
	}
	
	public boolean isFichaBlue() {
		return true;
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
		BlueFicha other = (BlueFicha) obj;
		return Objects.equals(colour, other.colour);
	}










	
	

}

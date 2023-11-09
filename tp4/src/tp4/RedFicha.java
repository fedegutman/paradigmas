package tp4;

import java.util.Objects;

public class RedFicha extends Ficha {
	private String colour ;

	public RedFicha() {
		this.colour="red" ;
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
		RedFicha other = (RedFicha) obj;
		return Objects.equals(colour, other.colour);
	}
	
	
	
}

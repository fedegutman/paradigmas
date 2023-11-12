package tp4;

import java.util.Objects;

public class TypeC {
	public Character string ;
	
	public TypeC (String c) {
		this.string = 'c';
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(string);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeC other = (TypeC) obj;
		return Objects.equals(string, other.string);
	}

}


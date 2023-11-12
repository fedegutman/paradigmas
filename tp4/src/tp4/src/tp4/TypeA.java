package tp4;

import java.util.Objects;

public class TypeA {
	public Character string ;
	
	public TypeA (String c) {
		this.string = 'a';
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
		TypeA other = (TypeA) obj;
		return Objects.equals(string, other.string);
	}

}

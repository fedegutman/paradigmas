package tp4;

import java.util.Objects;

public class TypeB 	{
	
public Character string ;

public TypeB (String c) {
	this.string = 'b';
	
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
	TypeB other = (TypeB) obj;
	return Objects.equals(string, other.string);
}


}


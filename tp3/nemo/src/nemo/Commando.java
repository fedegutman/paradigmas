package nemo;

import java.util.Objects;

public abstract class Commando {
	
	public Character character ;
	
    public abstract boolean validCharacter(Character c);
	
	public abstract Nemo execute (Nemo nemo );

	@Override
	public int hashCode() {
		return Objects.hash(character);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commando other = (Commando) obj;
		return Objects.equals(character, other.character);
	}
	
	
}

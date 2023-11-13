package tp4;

import java.util.Objects;

public class TypeA extends ModoJuego{
	
	public Character string ;
	public Linea game;
	
	public TypeA () {
		this.string = 'A';
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

	protected Character getModo() {
		return string;
	}

	public boolean gameWon(int x,Linea game) {
		return game.gameWonTypeA(x)== true;
	}

}

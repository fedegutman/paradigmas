package tp4;

import java.util.Objects;

public class TypeC extends ModoJuego{
	public Character string ;
	public Linea game;
	
	public TypeC () {
		this.string = 'C';
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



	protected Character getModo() {
		return string;
	}



	public boolean gameWon(int x, Linea game) {
		return game.gameWonTypeB(x)||game.gameWonTypeA(x)== true ;
	}

}


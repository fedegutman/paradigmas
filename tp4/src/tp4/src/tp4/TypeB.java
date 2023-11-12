package tp4;

import java.util.Objects;

public class TypeB extends ModoJuego{
public Character string ;
public Linea game;

public TypeB () {
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

protected Character getModo() {
	return 'b';
}

public boolean gameWon(int x, Linea game) {
	return game.gameWonTypeB(x)== true;
}


}


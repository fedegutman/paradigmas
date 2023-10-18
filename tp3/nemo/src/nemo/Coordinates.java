package nemo;

import java.util.Objects;

// metodo get coordinates de quien es responsabilidad

public class Coordinates {
	
	private int x;
	private int y;
	
	public Coordinates(int i, int j) {
		x = i;
		y = j;
	}
	
	public Coordinates add(Coordinates coordinate) {
		x += coordinate.x;
		y += coordinate.y;
		return this;

	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		return x == other.x && y == other.y;
	}
	
}

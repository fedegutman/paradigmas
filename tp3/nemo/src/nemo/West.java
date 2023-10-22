package nemo;

public class West extends Direction {
	
	@Override
	public Direction turnLeft() {
		return new South();
	}

	@Override
	public Direction turnRight() {
		return new North();
	}

	@Override
	public Coordinates moveFoward() {
		return new Coordinates (-1,0);
	}
}
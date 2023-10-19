package nemo;

public class West extends Direction {
	
	public West() {
	}

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
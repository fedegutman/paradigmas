package nemo;

public class East extends Direction {
	
	@Override
	public Direction turnLeft() {
		return new North();
	}

	@Override
	public Direction turnRight() {
		return new South();
	}

	@Override
	public Coordinates moveFoward() {
		return new Coordinates (1,0);
	}
}

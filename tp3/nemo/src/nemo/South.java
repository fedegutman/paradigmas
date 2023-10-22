package nemo;

public class South extends Direction {
	
	@Override
	public Direction turnLeft() {
		return new East();
	}

	@Override
	public Direction turnRight() {
		return new West();
	}

	@Override
	public Coordinates moveFoward() {
		return new Coordinates (0,-1);
	}
}
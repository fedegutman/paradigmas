package nemo;

public class North extends Direction {
	
	public North() {
	}

	@Override
	public Direction turnLeft() {
		return new West();
	}

	@Override
	public Direction turnRight() {
		return new East();
	}

	@Override
	public Coordinates moveFoward() {
		return new Coordinates (0,1);
	}
	

}
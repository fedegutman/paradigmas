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

}

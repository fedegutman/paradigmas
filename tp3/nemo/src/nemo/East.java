package nemo;

public class East extends Direction {
	
	public East() {
	}

	@Override
	public Direction turnLeft() {
		return new North();
	}

	@Override
	public Direction turnRight() {
		return new South();
	}

	@Override
	Direction moveFoward() {
		// TODO Auto-generated method stub
		return null;
	}

}

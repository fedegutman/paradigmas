package nemo;

public class Right extends Commands {
	
	public Character character = 'r' ;

	@Override
	public Nemo execute(Nemo nemo) {
		nemo.turnRight();
		return nemo ;
	}

	@Override
	public Character getChar() {
		return character;
	}
}

package nemo;


public class Right extends Commando {
	
	public Character character = 'r' ;

	@Override
	public Nemo execute(Nemo nemo) {
		nemo.turnRight();
		return nemo ;
	}

	@Override
	public boolean validCharacter(Character c) {
		return character == c;
	}
}

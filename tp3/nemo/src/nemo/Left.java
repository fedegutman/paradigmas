package nemo;


public class Left extends Commando {
	
	public Character character = 'l' ;

	@Override
	public Nemo execute(Nemo nemo) {
		nemo.turnLeft() ;
		return nemo ;
	}

	@Override
	public boolean validCharacter(Character c) {
	return character == c;
		}
	
	
}

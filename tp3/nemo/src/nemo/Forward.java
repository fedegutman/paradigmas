package nemo;


public class Forward extends Commando {
	
	public Character character = 'f' ;

	@Override
	public Nemo execute(Nemo nemo) {
		nemo.forward () ;
		return nemo ;
	}

	@Override
	public boolean validCharacter(Character c) {
		return character == c;
	}
}
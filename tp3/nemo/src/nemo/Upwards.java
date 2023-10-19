package nemo;


public class Upwards extends Commando {
	
	public Character character = 'u' ;

	@Override
	public Nemo execute(Nemo nemo) {
		nemo.take() ;
		return nemo ;
	}
	
	@Override
	public boolean validCharacter(Character c) {
		return character == c;
	}
}
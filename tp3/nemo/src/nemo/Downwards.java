package nemo;


public class Downwards extends Commando {
	
	public Character character = 'd' ;

	@Override
	public Nemo execute(Nemo nemo) {
		nemo.add(nemo) ;
		return nemo ;
	}
	
	@Override
	public boolean validCharacter(Character c) {
		return character == c;
	}
}
package nemo;

public class Forward extends Commands {
	
	public Character character = 'f' ;

	@Override
	public Nemo execute(Nemo nemo) {
		nemo.goForward () ;
		return nemo ;
	}

	@Override
	public boolean validCharacter(Character c) {
		return character == c;
	}
}

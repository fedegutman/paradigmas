package nemo;

public class Upwards extends Commands {
	
	public Character character = 'u' ;

	@Override
	public Nemo execute(Nemo nemo) {
		nemo.take() ;
		return nemo ;
	}

	@Override
	public Character getChar() {
		return character;
	}
}
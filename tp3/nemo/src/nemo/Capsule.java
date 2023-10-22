package nemo;

public class Capsule extends Commands {
	
	public Character character = 'm' ;
	
	@Override
	public Nemo execute(Nemo nemo) {
		nemo.releaseCapsule() ;
		return nemo;
	}

	@Override
	public Character getChar() {
		return character;
	}
}

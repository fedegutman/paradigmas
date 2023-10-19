package nemo;

public class Capsula extends Commando {
	
	public Character character = 'm' ;
	
	@Override
	public Nemo execute(Nemo nemo) {
		nemo.releaseCapsule() ;
		return nemo;
	}

	@Override
	public boolean validCharacter(Character c) {
		return character == c;
}

}

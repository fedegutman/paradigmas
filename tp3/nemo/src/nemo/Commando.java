package nemo;

public abstract class Commando {
	
	public Character character ;
	
    public abstract boolean validCharacter(Character c);
	
	public abstract Nemo execute (Nemo nemo );

	

	
}

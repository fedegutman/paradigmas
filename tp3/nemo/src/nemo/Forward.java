package nemo;


public class Forward extends Commando {
	
	public Character character = 'f' ;

	@Override
	public Nemo execute(Nemo nemo) {
		nemo.forward () ;
		return nemo ;
	}
}

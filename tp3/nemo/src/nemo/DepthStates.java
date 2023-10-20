package nemo;

public abstract class DepthStates {
	
	private static Object cargo;


	public static DepthStates superficie() {
		return new Superficie ();
	}
	
	public static DepthStates nivelUno() {
		return new NivelUno (cargo);
	}
	
	public static DepthStates profundo() {
		return new Profundo (cargo);
	}
	
	public abstract Object take ();
	
	public abstract DepthStates add (Object cargo);
	
	public abstract Object releaseCapsule () ;
	
	public abstract int size();


}

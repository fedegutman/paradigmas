package nemo;

public abstract class DepthStates {
	
	private static Object depthlevel;

	public static DepthStates superficie() {
		return new Surface();
	}
	
	public static DepthStates nivelUno() {
		return new FirstImmersion(depthlevel);
	}
	
	public static DepthStates profundo() {
		return new Profundity(depthlevel);
	}
	
	public abstract Object take();
	
	public abstract DepthStates add(Object cargo);
	
	public abstract Object releaseCapsule() ;
	
	public abstract int size();

}

package nemo;

public class FirstImmersion extends DepthStates {
		
	public FirstImmersion(Object depthlevel) {}
	
	@Override
	public Object take() {
		return new Surface();
	}

	@Override
	public DepthStates add(Object depthlevel) {
		return new Profundity(depthlevel);
	}

	@Override
	public Object releaseCapsule() {
		return null;
	}

	@Override
	public int size() {
		return 1;
	}

}

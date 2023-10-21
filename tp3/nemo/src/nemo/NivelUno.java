package nemo;

public class NivelUno extends DepthStates {
		
	public NivelUno(Object cargo) {
	}
	
	@Override
	public Object take() {
		return new Superficie();
	}

	@Override
	public DepthStates add(Object cargo) {
		return new Profundo(cargo);
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

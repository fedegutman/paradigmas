package nemo;

public class Surface extends DepthStates {

	@Override
	public Object take() {
		return null;
	}

	@Override
	public DepthStates add(Object depthlevel) {
		return nivelUno();
	}

	@Override
	public Object releaseCapsule () {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}

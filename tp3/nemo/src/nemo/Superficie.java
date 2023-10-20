package nemo;

public class Superficie extends DepthStates {

	@Override
	public Object take() {
		return null;
	}

	@Override
	public DepthStates add(Object cargo) {
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

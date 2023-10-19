package nemo;

import java.util.ArrayList;

public class NivelUno extends DepthStates {
	
	private ArrayList<Object> items = new ArrayList<>();
	
	
	public NivelUno(Object cargo) {
		items.add(cargo);
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
	public boolean releaseCapsule() {
		return true;
	}

	@Override
	public int size() {
		return items.size();
	}

}

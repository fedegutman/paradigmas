package nemo;

import java.util.ArrayList;

public class Profundo extends DepthStates {

	private ArrayList<Object> items = new ArrayList<>();

	public Profundo(Object cargo) {
		items.add(cargo);
	}
	
	@Override
	public Object take() {
		return items.remove(0);
	}


	@Override
	public DepthStates add(Object cargo) {
		items.add(cargo);
		return this;
	}

	@Override
	public boolean releaseCapsule() {
		return false;
	}

	@Override
	public int size() {
		return items.size() +1 ;
	}

}

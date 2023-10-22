package nemo;

import java.util.ArrayList;

public class Profundity extends DepthStates {

	private static String Explosion = "Submarine Explosion";
	
	private ArrayList<Object> items = new ArrayList<>();

	public Profundity(Object depthlevel) {
		items.add(new FirstImmersion(depthlevel));
		items.add(depthlevel);
	}
	
	@Override
	public Object take() {
		return items.remove(0);
	}

	@Override
	public DepthStates add(Object depthlevel) {
		items.add(depthlevel);
		return this;
	}

	@Override
	public Object releaseCapsule() {
		throw new Error(Explosion);	}

	@Override
	public int size() {
		return items.size() ;
	}
}

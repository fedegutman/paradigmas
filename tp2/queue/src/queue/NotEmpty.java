package queue;

import java.util.ArrayList;

public class NotEmpty extends QueueStates {

	private ArrayList<Object> items = new ArrayList<>();

	public NotEmpty(Object cargo) {
		items.add(cargo);
	}

	public Object take() {
		return items.remove(0);
	}

	public Object head() {
		return items.get(0);
	}
	
	public boolean isEmpty() {
		return items.isEmpty(); // transformar de empty a isempty
	}
	
	public QueueStates add(Object cargo) {
		items.add(cargo);
		return this;
	}
	
	public int size() {
		return items.size();
	}

}
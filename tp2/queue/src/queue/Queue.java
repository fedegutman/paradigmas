package queue;

import java.util.ArrayList;

public class Queue {

	private ArrayList<QueueStates> items = new ArrayList<>();

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public Queue add(Object cargo) {
		items.add(new NotEmpty(cargo));
		return this;
	}

	public Object take() {
		return items.remove(0).content(); // problema aca // problema de pasar de notempty a empty
	}

	public Object head() {
		return items.get(0).content(); // problema aca 
	}

	public int size() {
		return items.size();
	}

}
package queue;

import java.util.ArrayList;

public class NotEmpty extends QueueStates {

	private ArrayList<Object> items = new ArrayList<>();
	private Object cargo;

	public NotEmpty(Object cargo) {
		this.cargo = cargo;
	}

	public Object take() {
		return items.remove(0);
	}

	public Object head() {
		return items.get(0);
	}

}

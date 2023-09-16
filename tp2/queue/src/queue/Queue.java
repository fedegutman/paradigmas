package queue;

import java.util.ArrayList;

public class Queue {
	
  private ArrayList<Object> items = new ArrayList<>();


  public boolean isEmpty() {
		return items.isEmpty();
	}

	public Queue add( Object  cargo ) {
		items.add(cargo);
		return this;
	}

	public Object take() {
		if (!items.isEmpty()) {
			Object elem = items.get(0);
			return elem;
		} else {
			throw new Error( "Queue is empty" );
		}
	}

	public Object head() {
		if (!items.isEmpty()) {
			Object elem = items.get(0);
			return elem;
		} else {
			throw new Error( "Queue is empty" );
		}
	}

	public int size() {
		return items.size();
	}

}

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
			return items.remove(0);
		} else {
			throw new Error( "Queue is empty" );
		}
	}

	public Object head() {
		if (!items.isEmpty()) {
			return items.get(0);
		} else {
			throw new Error( "Queue is empty" );
		}
	}

	public int size() {
		return items.size();
	}

}

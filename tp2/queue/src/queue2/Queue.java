package queue2;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	private int length;
	private List<Object> items = new ArrayList<>();



  public Queue() {
	this.length = 0;
		
	}
  
  public boolean isEmpty() {
		
		return items.size() == 0;
	}

	public Queue add( Object  cargo ) {
		items.add(0, cargo);
		return this;
	}

	public Object take() {
        if (isEmpty()) {
            throw new Error("Queue is empty");
        }
        return items.remove(0);
	}

	public Object head() {
        if (isEmpty()) {
            throw new Error("Queue is empty");
        }
        return items.get(0);
    }

	public int size() {
    return items.size();
	}

}

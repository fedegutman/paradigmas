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
		// TODO Auto-generated method stub
		return length == 0;
	}

	public Queue add( Object  cargo ) {
		// TODO Auto-generated method stub
		return this;
	}

	public Object take() {
    // TODO Auto-generated method stub
		return null;
	}

	public Object head() {
		// TODO Auto-generated method stub
    return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}

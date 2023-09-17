package queue;

public class Empty extends QueueStates {

	public Object head() {
		throw new Error("Queue is empty");
	}

	public Object take() {
		throw new Error("Queue is empty");
	}
	
	public boolean isEmpty() {
		return true;
	}
	
	public QueueStates add(Object cargo) {
		return new NotEmpty(cargo);
	}
	
	public int size() {
		return 0;
	}

}

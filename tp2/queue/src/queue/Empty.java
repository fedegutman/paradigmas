package queue;

public class Empty extends QueueStates {

	private static String EmptyQueue = "Queue is empty";

	public Object head() {
		throw new Error(EmptyQueue);
	}

	public Object take() {
		throw new Error(EmptyQueue);
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

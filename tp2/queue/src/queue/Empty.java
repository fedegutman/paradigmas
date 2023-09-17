package queue;

public class Empty extends QueueStates {

	public Object head() {
		throw new Error("Queue is empty");
	}

	public Object take() {
		throw new Error("Queue is empty");
	}

	@Override
	public Object content() {
		throw new Error("Queue is empty");
	}

}

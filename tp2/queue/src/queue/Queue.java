package queue;

public class Queue {

	private QueueStates state = QueueStates.empty();

	public boolean isEmpty() {
		return state.isEmpty();
	}

	public Queue add(Object cargo) {
		state = state.add(cargo);
		return this;
	}

	public Object take() {
		if (state.isEmpty()) {
			return new Empty().take();
		} else {
			return state.take();
		}
	}

	public Object head() {
		return state.head(); // problema aca
	}

	public int size() {
		return state.size();
	}

}
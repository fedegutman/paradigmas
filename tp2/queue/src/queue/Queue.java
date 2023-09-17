package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

	private QueueStates state = QueueStates.empty();
    private List<QueueStates> stateHistory = new ArrayList<>();
    
    public Queue() {
        stateHistory.add(state);
    }

	public boolean isEmpty() {
		return state.isEmpty();
	}

	public Queue add(Object cargo) {
		state = state.add(cargo);
		stateHistory.add(state);
		return this;
	}

	public Object take() {
		Object item = state.take();
		stateHistory.remove(stateHistory.size() - 1);
		state = stateHistory.get(stateHistory.size() - 1);
		return item;
	}

	public Object head() {
		return state.head();
	}

	public int size() {
		return state.size();
	}

}
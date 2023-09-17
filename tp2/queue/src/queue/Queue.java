package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

	private QueueStates state = QueueStates.empty();
    private List<QueueStates> statehistory = new ArrayList<>();
    
    public Queue() {
        statehistory.add(state);
    }

	public boolean isEmpty() {
		return state.isEmpty();
	}

	public Queue add(Object cargo) {
		state = state.add(cargo);
		statehistory.add(state);
		return this;
	}

	public Object take() {
		Object item = state.take();
		statehistory.remove(statehistory.size() - 1);
		state = statehistory.get(statehistory.size() - 1);
		return item;
	}

	public Object head() {
		return state.head();
	}

	public int size() {
		return state.size();
	}

}

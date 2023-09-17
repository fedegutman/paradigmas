package queue;

public abstract class QueueStates {

	private static Object cargo;

	public static QueueStates empty() {
		return new Empty();
	}

	public static QueueStates notEmpty() {
		return new NotEmpty(cargo);
	}

	public abstract boolean isEmpty();
	
	public abstract Object take();

	public abstract Object head();
	
	public abstract QueueStates add(Object cargo);
		
	public abstract int size();
}
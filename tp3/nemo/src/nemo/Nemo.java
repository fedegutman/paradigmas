package nemo;

import java.util.ArrayList;
import java.util.Arrays;

public class Nemo {

	public Coordinates coordinates;
	public Direction direction;
	public ArrayList<DepthStates> depthHistory = new ArrayList<>();
	public DepthStates state = DepthStates.superficie();

	public Nemo(Coordinates initialPosition, Direction initialDirection) {
		coordinates = initialPosition ;
		direction = initialDirection ;
		depthHistory.addAll(Arrays.asList(state));
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public Nemo turnLeft() {
		direction = direction.turnLeft() ;
		return this;
	}

	public Nemo turnRight() {
		direction = direction.turnRight();
		return this;
	}
	
	public Nemo goForward() {
		coordinates = coordinates.add(direction.moveFoward());
		return this;
	}
	
	public Nemo runCommand(Character charCommand) {
		Commands command = Commands.getCommand(charCommand);
		return command.execute(this);
	}
	
	public Nemo move(String stringCommand) {
	    stringCommand.chars().forEach(c -> runCommand((char) c));
	    return this;
	}
	
	public Object releaseCapsule() {
		state.releaseCapsule();
		return this;
	}
	
	public int profundidad () {
		return -state.size();
	}
	
	public Nemo add (Object item) {
		state = state.add(item);
		depthHistory.add(state);
		return this;
	}
	
	public Object take() {
		state.take();
		depthHistory.remove(depthHistory.size() - 1);
		state = depthHistory.get(depthHistory.size() - 1);
		return this;
	}
}

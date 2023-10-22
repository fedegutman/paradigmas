package nemo;

import java.util.ArrayList;
import java.util.Arrays;

public class Nemo {

	public Coordinates coordinates;
	public Direction direction;
	public ArrayList<Commands> commands = new ArrayList<>();
	public ArrayList<DepthStates> depthHistory = new ArrayList<>();
	public DepthStates state = DepthStates.superficie();

	public Nemo(Coordinates initialPosition, Direction initialDirection) {
		coordinates = initialPosition ;
		direction = initialDirection ;
		commands.addAll(Arrays.asList(new Left(), new Right(), new Forward(), new Upwards(), new Downwards(), new Capsule()));
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
		Commands command = commands.stream().filter(c -> c.getChar() == charCommand).findFirst().orElse(null);
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

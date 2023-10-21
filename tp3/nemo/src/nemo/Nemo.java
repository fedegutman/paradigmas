package nemo;

import java.util.ArrayList;
import java.util.Arrays;



public class Nemo {

	public Coordinates coordinates;
	public Direction direction;
	public ArrayList<Commando> commands;
	public ArrayList<DepthStates> depthHistory ;
	public DepthStates state = DepthStates.superficie() ;


	public Nemo(Coordinates initialPosition, Direction initialDirection) {
		
		coordinates = initialPosition ;
		direction = initialDirection ;
		commands = new ArrayList<>(Arrays.asList(new Left(), new Right(), new Forward(), new Upwards(),new Downwards(),new Capsula()));
		depthHistory = new ArrayList<>(Arrays.asList(state));
	}

	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public Nemo turnLeft() {
		direction=direction.turnLeft() ;
		return this ;
	}

	public Nemo turnRight() {
		direction=direction.turnRight();
		return this ;
	}
	
	public Nemo forward() {
		coordinates = coordinates.add(direction.moveFoward());
		return this;
	}
	
	public Nemo executeCommando(Character commandChar) {
		Commando actualCommando = commands.stream().filter(x -> x.validCharacter(commandChar)).findFirst().orElse(null);		
		return actualCommando.execute(this);
	}
	
	public Nemo move(String commandString) {
	    commandString.chars().forEach(x -> executeCommando((char) x));
	    return this;
	}
	
	public Object releaseCapsule() {
		state.releaseCapsule();
		return this;
		
	}
	
	public Nemo add (Object cargo) {
		state = state.add(cargo);
		depthHistory.add(state);
		return this;
	}
	
	public int profundidad () {
		return -state.size();
	}
	
	public Object take() {
		state.take();
		depthHistory.remove(depthHistory.size() - 1);
		state = depthHistory.get(depthHistory.size() - 1);
		return this;
	}


};

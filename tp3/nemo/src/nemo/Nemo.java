package nemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;





//import java.util.List;
//import java.util.ArrayList;

public class Nemo {

	public Coordinates coordinates;
	public Direction direction;
	public ArrayList<Commando> commands;
	private ArrayList<DepthStates> depthHistory ;
	private DepthStates state = DepthStates.superficie() ;


	public Nemo() {
		
		coordinates = new Coordinates(0,0);
		direction = new North();
		commands = new ArrayList<>(Arrays.asList(new Left(), new Right(), new Forward(), new Upwards(),new Downwards(),new Capsula()));
		depthHistory = new ArrayList<>(Arrays.asList(state));
	}

			;

	public Nemo changeCoordinate(String direction) {
		if (direction == "") {
			return this;
		}
		return null;

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
		Commando actualCommando = commands.stream().filter(c -> c.validCharacter(commandChar)).findFirst().orElse(null);		
		return actualCommando.execute(this);
	}
	
	public Nemo move(String commandString) {
	    commandString.chars().forEach(c -> executeCommando((char) c));
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
		Object item = state.take();
		depthHistory.remove(depthHistory.size() - 1);
		state = depthHistory.get(depthHistory.size() - 1);
		return item;
	}


};

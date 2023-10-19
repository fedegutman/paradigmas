package nemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;




//import java.util.List;
//import java.util.ArrayList;

public class Nemo {

	public Coordinates coordinates;
	public Direction direction;
	public int depth;
	public ArrayList<Commando> commands;
	public ArrayList<DepthStates> depthHistory ;
	private DepthStates state = DepthStates.superficie() ;


	public Nemo() {
		depth = 0;
		coordinates = new Coordinates(0,0);
		direction = new North();
		commands = new ArrayList<>(Arrays.asList(new Left(), new Right(), new Forward(), new Upwards(),new Downwards()));
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
		Commando actualCommando = commands.stream().filter(c -> c.validCharacter(commandChar));		
		return actualCommando.execute(this);
	}
	
	public Nemo move(String commandString) {
		for (char comando : commandString.toCharArray()) {
			this.executeCommando(comando);
		}
		return this;
	}
	public Nemo releaseCapsule() {
		state = depthHistory.get(depthHistory.size() - 1);
		state.releaseCapsule();
		return this;
		
	}
	
	public Nemo add (Object cargo) {
		state = state.add(cargo);
		depthHistory.add(state);
		return this;
	}
	
	public int profundidad () {
		return depth = state.size();
	}
	
	public Object take() {
		Object item = state.take();
		depthHistory.remove(depthHistory.size() - 1);
		state = depthHistory.get(depthHistory.size() - 1);
		return item;
	}
	



	
//	public Nemo takeStep(char step) {
////		if (step.) {
////			return this;
////		}
//			if (step == 'd') {
//				this.depth -= 1;
//				return this;
//			}
//			else if (step == 'u') {
//				// si depth es 0 no puedo subir mas
//				this.depth += 1;
//				return this;
//		}
//			
//		return null;
//
//	}

};

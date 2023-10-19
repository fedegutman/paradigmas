package nemo;

import java.util.ArrayList;

//import java.util.List;
//import java.util.ArrayList;

public class Nemo {

	public Coordinates coordinates;
	public Direction direction;
	public int depth;
	public ArrayList<Commando> commands;



	public Nemo() {
		depth = 0;
		coordinates = new Coordinates(0,0);
		direction = new North();

			};

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
	
	public Nemo executeCommando (Character character) {  //no se si esta bien
		    commands.forEach(command -> command.execute(this));
		    return this;
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

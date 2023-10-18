package nemo;

//import java.util.List;
//import java.util.ArrayList;

public class Nemo {

	public Coordinates coordinates;
	public Direction direction;
	public int depth;


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
	
	public Nemo takeStep(char step) {
//		if (step.) {
//			return this;
//		}
			if (step == 'd') {
				this.depth -= 1;
				return this;
			}
			else if (step == 'u') {
				// si depth es 0 no puedo subir mas
				this.depth += 1;
				return this;
		}
			
		return null;

	}

};

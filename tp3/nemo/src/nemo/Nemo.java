package nemo;

//import java.util.List;
//import java.util.ArrayList;

public class Nemo {

	public int depth;
	public int xcoordinate;
	public int ycoordinate;
	public String direction;

	public Nemo() {
		depth = 0;
		xcoordinate = 0;
		ycoordinate = 0;
		direction = "North";

	};

	public Nemo changeCoordinate(String direction) {
		if (direction == "") {
			return this;
		}
		return null;

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

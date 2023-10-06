package nemo;

//import java.util.List;
//import java.util.ArrayList;

public class Nemo {

	public int depth;
	public int xcoordinate;
	public int ycoordinate;
	public String direction;
	public boolean capsule ;

	public Nemo() {
		depth = 0;
		xcoordinate = 0;
		ycoordinate = 0;
		direction = "North";
		capsule = true ;

	};

	public Nemo changeCoordinate(String direction) {
		if (direction == "") {
			return this;
		}
		else {
	        direction.chars().forEach(step -> {
	            char stepChar = (char) step;
	            takeStep(stepChar);
	        });
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
			else if (step == 'l' && direction == "North") {
				this.direction = "West";
				return this;
			}
			else if (step == 'r'&& direction == "North") {
				this.direction = "East";
				return this;

			}
			else if (step == 'r' && direction == "East") {
				this.direction = "South";
				return this;

			}
			
			else if (step == 'r'&& direction == "South") {
				this.direction = "West";
				return this;

			}
			
			else if (step == 'r'&& direction == "West") {
				this.direction = "North";
				return this;

			}
			
			else if (step == 'l'&& direction == "West") {
				this.direction = "South";
				return this;

			}
			
			
			else if (step == 'l'&& direction == "South") {
				this.direction = "East";
				return this;

			}
			
			else if (step == 'l'&& direction == "East") {
				this.direction = "North";
				return this;

			}
			
		
			else if (step == 'f'&& direction == "North") {
				this.ycoordinate +=1 ;
				return this;

			}
			else if (step == 'f' && direction == "East") {
				this.xcoordinate +=1;
				return this;

			}
			
			else if (step == 'f'&& direction == "South") {
				this.ycoordinate -=1;
				return this;

			}
			
			else if (step == 'f'&& direction == "West") {
				this.xcoordinate -=1;
				return this;

			}
			
			else if (step == 'm' && depth < -1 ) {
				this.capsule = false ;
				return this ;
			}
			return this;
			
			

};}
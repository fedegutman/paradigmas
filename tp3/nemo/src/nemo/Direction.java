package nemo;

public abstract class Direction {
	
	public abstract Direction turnLeft();
	
	public abstract Direction turnRight();
	
	public abstract Coordinates moveFoward();
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}

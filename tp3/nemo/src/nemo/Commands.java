package nemo;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Commands {
	
	public static ArrayList<Commands> commands = new ArrayList<>(
			Arrays.asList(
					new Left(), 
					new Right(), 
					new Forward(), 
					new Upwards(), 
					new Downwards(), 
					new Capsule()));
	
	public Character character;
		
	public abstract Nemo execute (Nemo nemo);
	
	public abstract Character getChar();
	
	public static Commands getCommand(Character command) {
		return commands.stream().filter(c -> c.getChar().equals(command)).findFirst().orElse(null);
	}
		
}

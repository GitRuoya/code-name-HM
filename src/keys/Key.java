package keys;

import main.Runner;
import utilities.Output;
import values.Value;

public class Key {
	
	protected Value value;
	protected String name;
	
	public void assign(Value value) {
		if (this.value == null) {
			if (value.canAssignTo(this)) {				
				this.value = value;
				Runner.removeFromRoom(value);					
				Output.print("You put the " + value.getName() + " in your " + name + ".");
			}
		} else {
			Output.print("You already have the " + this.value.getName() + " in your " + name + ".");
		}
	}

	public void use() {
		if (value == null) {
			Output.print("You have nothing in your " + name + ".");
		} else {
			value.use();
		}
	}
	
	public void remove() {
		if (value == null) {
			Output.print("You have nothing in your " + name + ".");
		} else {
			Output.print("You remove the " + value.getName() + " from your " + name + ".");
			Runner.addToRoom(value);
			value = null;
		}
	}
	
	public String getName() {
		return name;
	}
	public Value getValue() {
		return value;
	}
	
}

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
				if (Runner.firstAssign) {
					Output.print("You put the " + value.getName() + " in your " + name + "."
							+ "\nWhile it is in your " + name + ", you will only be able to access it via said " + name + "."
							+ "\nIf you'd like to use a different key on it, you can REMOVE it from this key.");
					Runner.firstAssign = false;
				} else {					
					Output.print("You put the " + value.getName() + " in your " + name + ".");
				}
			}
		} else {
			Output.print("You already have the " + value.getName() + " in your " + name + ".");
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

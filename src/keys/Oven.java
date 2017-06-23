package keys;

import main.Runner;
import utilities.Output;
import values.Heatable;
import values.Value;

public class Oven extends Key {

	private boolean open;
	
	private long beginHeatTime;
	private long duration;

	public Oven() {
		name = "OVEN";
		open = true;
	}

	public void swingDoor() {
		if (open) {
			Output.print("You swing the OVEN DOOR closed, thus turning the " + name + " on.");
			beginHeatTime = System.currentTimeMillis();
		} else {
			Output.print("You swing the OVEN DOOR open, thus turning the " + name + " off.");
			duration += System.currentTimeMillis() - beginHeatTime;
		}
		open = !open;
	}
	
	@Override
	public void use() {
		if (value == null) {
			Output.print("You have nothing in the " + name + ".");
		} else {			
			if (Runner.firstTryUseContainer) {			
				Output.print("The " + name + " is a container. You cannot \"USE\" anything from within it."
						+ "\nInstead, it may be advisable to assign the " + value.getName() + " to one of your other keys, instead.");
				Runner.firstTryUseContainer = false;
			} else {
				Output.print("No matter how hard you try, you will be unable to USE anything from the " + name + ".");
			}
		}
	}

	@Override
	public void assign(Value value) {
		if (open) {
			if (this.value == null) {
				if (value.canAssignTo(this)) {
					this.value = value;
					Runner.removeFromRoom(value);
					if (value instanceof Heatable) {
						Output.print("You put the " + value.getName() + " in the " + name + ".");
						duration = 0;
					} else {
						Output.print("You put the " + value.getName() + " in the " + name + "."
								+ "\nHowever, you get the feeling heating the " + value.getName() + " will not effect it.");
					}
				}
			} else {
				Output.print("You already have the " + this.value.getName() + " in the " + name + ".");
			}
		} else {
			Output.print("The " + name + " is closed right now.");
		}
	}
	
	public void remove() {
		if (value == null) {
			Output.print("You have nothing in the " + name + ".");
		} else {
			Output.print("You remove the " + value.getName() + " from the " + name + ".");
			if (value instanceof Heatable && duration != 0) {
				((Heatable) value).heat(duration);
			}
			Runner.addToRoom(value);
			value = null;
		}
	}

}

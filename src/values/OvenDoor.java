package values;

import keys.Hand;
import keys.Key;
import keys.Oven;
import main.Runner;
import utilities.Output;

public class OvenDoor extends Value {

	private boolean firstOpen;
	private Oven oven;
	
	public OvenDoor() {
		firstOpen = true;
	}
	
	@Override
	protected String initName() {
		return "OVEN DOOR";
	}
	
	@Override
	protected String checkText() {
		return "The microwave oven is a modern design, with a sleek-white exterior."
				+ "\nWithout any buttons, the door acts as the main controller to the device.";
	}
	

	@Override
	public boolean canAssignTo(Key k) {
		if (k instanceof Hand) {
			return true;
		} else if (k == oven) {
			Output.print("You try to stuff the " + name + " backwards into the " + k.getName() + ", but... that isn't going to happen."
					+ "\nWhat are you even trying to accomplish here?");
			return false;
		} else {
			Output.print("The " + name + " is fastened to the oven, and refuses to be placed in your " + k.getName() + ".");
			return false;
		}
	}
	
	@Override
	public void use() {
		if (firstOpen) {
			Output.print("You swing open the " + name + ", and the microwave oven comes to life. Figuratively speaking, of course."
					+ "\nWhile the door is OPEN, the oven will act as a CONTAINER in your inventory."
					+ "\nOn the flip side, while it is CLOSED, values inside will heat up!"
					+ "\nAfter a certain amount of real time with the door closed, certain values will react in different ways. Try it!");
			firstOpen = false;
			
			oven = new Oven();
			Runner.addToKeys(oven);
		} else {
			oven.swingDoor();
		}
	}

}

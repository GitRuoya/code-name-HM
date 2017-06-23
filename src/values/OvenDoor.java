package values;

import keys.Hand;
import keys.Key;
import keys.Oven;
import main.Runner;
import utilities.Output;

public class OvenDoor extends Value {

	private boolean tiedUp;
	private boolean firstOpen;
	private Oven oven;
	
	public OvenDoor() {
		tiedUp = true;
		firstOpen = true;
	}
	
	public boolean isTiedUp() {
		return tiedUp;
	}
	
	@Override
	protected String initName() {
		return "OVEN DOOR";
	}
	
	@Override
	protected String checkText() {
		if (tiedUp) {			
			Runner.seenRopeOnOvenDoor = true;
			return "The microwave oven is a modern design, with a sleek-white exterior."
					+ "\nHowever, the door appears to tied up with a rope! You'll need to cut it free first.";
		} else {
			return "The microwave oven is a modern design, with a sleek-white exterior."
					+ "\nWithout any buttons, the door acts as the main controller to the device.";
		}
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
	
	public void cutRope() {
		tiedUp = false;
		Output.print("With a little bit of work, the dulled edges cut through the ropes binding the " + name + "."
				+ "\nHuzzah! The " + name + " is now free to work with however you'd like.");	
	}
	
	@Override
	public void use() {
		if (tiedUp) {
			Runner.seenRopeOnOvenDoor = true;
			Output.print("The " + name + " appears to be tightly knotted up by a rope. You will need to cut it free first.");
		} else {			
			if (firstOpen) {
				Output.print("You swing open the " + name + ", and the microwave oven comes to life! Figuratively speaking, of course."
						+ "\nWhile the door is OPEN, the oven will act as a CONTAINER in your inventory."
						+ "\nOn the flip side, while it is CLOSED, values inside will heat up."
						+ "\nAfter a certain amount of real time with the door closed, certain values will react in different ways. Try it!");
				firstOpen = false;
				
				oven = new Oven();
				Runner.addToKeys(oven);
			} else {
				oven.swingDoor();
			}
		}
	}

}

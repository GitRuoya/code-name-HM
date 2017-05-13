package values;

import keys.Hand;
import keys.Key;
import utilities.Output;

public class Switch extends Value {

	private boolean firstFlipped;
	private boolean on;

	public Switch() {
		firstFlipped = true;
		on = false;
	}
	
	@Override
	public void use() {
		if (!on) {
			Output.setDefaultBuffer(6);			
		} else {
			Output.setDefaultBuffer(22);
		}
		if (firstFlipped) {
			Output.print("You flip the light switch. Nothing seems to happen, except..."
					+ "\nWoah. Woah woah woah. This text SHOULD NOT be sliding by THIS QUICKLY."
					+ "\nOH GOD HOW IS THIS EVEN A THING THAT IS ALLOWED TO BE HAPPENING RIGHT NOW."
					+ "\n...UMM MAYBE DON'T TAMPER WITH THAT THING????");
			firstFlipped = false;
		} else if (on) {
			Output.print("The light switch is flipped back to normal. Whew.");
		} else {
			Output.print("You flip the light switch back up, sharply raising the text speed once more. (!!!)");
		}
		on = !on;
	}
	
	@Override
	public boolean canAssignTo(Key k) {
		if (k instanceof Hand) {
			return true;
		} else {
			Output.print("The "+ name + " is stuck to the wall, and refuses to be placed in your " + k.getName() + ".");
			return false;
		}
	}

	@Override
	protected String initName() {
		return "LIGHT SWITCH";
	}

	@Override
	protected String checkText() {
		if (firstFlipped) {			
			return "It's a flick switch attached to the wall near the door. Seems pretty straightforward, except..."
					+ "\nOddly enough, it's off right now. Yet the room is still brilliantly lit!"
					+ "\nYou are guessing the switch is probably broken.";
		} else {
			return "This switch does not toggle the lights. O_O";
		}
	}

}

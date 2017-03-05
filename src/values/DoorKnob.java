package values;

import keys.Hand;
import keys.Key;
import utilities.Output;

public class DoorKnob extends Value {

	private boolean firstAttemptBreak;
	private boolean unlocked;
	
	public DoorKnob() {
		super();
		firstAttemptBreak = true;
		unlocked = false;
	}
	
	@Override
	protected void setName() {
		name = "DOOR_KNOB";
	}
	
	@Override
	protected void setCheckText() {
		checkText = "A sleek, wooden door knob is fixed to the only door in the room."
				+ "\nIf you intend on escaping, you are going to need a find a way to unlock it.";
	}
	
	@Override
	public boolean canAssignTo(Key k) {
		if (k instanceof Hand) {
			return true;
		} else {
			Output.print("The door knob is fastened to the door, and refuses to be placed in your " + k.getName() + ".");
			return false;
		}
	}
	
	@Override
	public void use() {
		if (!unlocked) {
			if (firstAttemptBreak) {				
				Output.print("You attempt to open the EXIT_DOOR. However it is locked."
						+ "\nIt appears that no matter how much you twist and attack the " + name + ", the door shall remain immobile.");
				firstAttemptBreak = false;
			} else {
				Output.print("Your continued attempts to break open the locked door yields no success."
						+ "\nYou wouldn't want to break the " + name + " off and have it become a recurring motif, would you?");
			}
		} else {
			//TODO: Insert cryptic end game message.  :o
		}
	}
	
}

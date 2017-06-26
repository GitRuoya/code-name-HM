package values;

import keys.Key;
import keys.Oven;
import main.Runner;
import utilities.Output;

public class Scissors extends Value {

	private OvenDoor door;
	
	public Scissors(OvenDoor door) {
		this.door = door;
	}
	
	@Override
	protected String initName() {
		return "SCISSORS";
	}

	@Override
	public boolean canAssignTo(Key k) {
		if (k instanceof Oven) {
			if (Runner.firstTryElectricalFire) {
				Output.print("You put the " + name + " in the OVE-"
						+ "\nHey wait a minute, what do you think you're doing? Under no circumstance does metal go in this oven!"
						+ "\nLook, I know you want to escape, but maaaaaybe try to avoid destroying everything in an electrical fire?");
				Runner.firstTryElectricalFire = false;
			} else {
				Output.print("You refuse to put the " + name + " in the " + k.getName() + ".");
			}
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected String checkText() {
		if (!Runner.seenRopeOnOvenDoor) {			
			return "It appears to be a baby-blue pair of children's scissors, with relatively small plastic handles."
					+ "\nYou won't be able to cut through much with these. Maybe a bundle of rope, at most.";
		} else {
			return "It appears to be a baby-blue pair of children's scissors, with relatively small plastic handles."
					+ "\nIts blades are somewhat dull, but the scissors are nonetheless still functional.";
		}
	}
	
	@Override
	public void use() {
		if (!Runner.seenRopeOnOvenDoor) {
			Output.print("You've got a pair of scissors, but you can't think of anything you'd like to cut.");
		} else {
			if (door.isTiedUp()) {				
				Key k = Runner.findKeyWithValue(door);
				if (k == null) {	//The door is not in any of your values.				
					door.cutRope();
				} else {
					Output.print("You would cut open the ropes on the " + door.getName() + ", but it is currently in your " + k.getName() + " and not visible in the room.");
				}
			} else {
				Output.print("You've got a pair of scissors, but you can't think of anything else you'd like to cut.");
			}
		}
	}

}

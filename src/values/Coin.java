package values;

import keys.Key;
import keys.Oven;
import main.Runner;
import utilities.Output;

public class Coin extends Value {

	//All this for an obscure literary reference???
	private static final int STOPPARD_CONSTANT = 92;
	
	//TODO: If this gets released to a larger audience, remind me to up this value here.
	private static final int CONS_NEEDED = 5;
	private int consecutive;
	private boolean gotConsecutive;

	public Coin() {
		consecutive = 0;
		gotConsecutive = false;
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
	public void use() {
		if (!gotConsecutive) {
			if (consecutive >= CONS_NEEDED) {
				consecutive++;
				if (consecutive < STOPPARD_CONSTANT) {					
					Output.print("You flip the coin. Heads again.");
				} else {
					Output.print("You've flipped heads. Again. This is the 92nd time, in fact."
							+ "\nGuildenstern informs you that perhaps this coin is \"within un-, sub-, or supernatural forces.\"");
					gotConsecutive = true;
				}
			} else if (Math.random() > 0.5f) {
				consecutive++;
				Output.print("You flip the coin. Heads.");
			} else {
				Output.print("You flip the coin. Tails.");
				consecutive = 0;
			}
		} else {
			if (Math.random() > 0.5f) {
				Output.print("You flip the coin. Heads.");
			} else {
				Output.print("You flip the coin. Tails.");
			}
		}
	}

	@Override
	protected String initName() {
		return "COIN";
	}

	@Override
	protected String checkText() {
		return "A single coin lies in your view. It glitters with the mysteries of foreign currency."
				+ "\nLooking at its awesome luster, you cannot help but feel tempted by the cruelest disease of the soul.";
	}

}

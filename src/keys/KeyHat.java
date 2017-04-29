package keys;

import main.Runner;
import utilities.Output;
import values.Badge;
import values.Value;

public class KeyHat extends Key {
	
	private boolean hasTriedBadge;
	
	public KeyHat() {
		name = "HAT";
		hasTriedBadge = false;
	}
	
	@Override
	public void assign(Value value) {
		if (value instanceof Badge) {
			if (this.value == null) {
				this.value = value;
				Runner.removeFromRoom(value);
				if (!hasTriedBadge) {
					Output.print("You pin the " + value.getName() + " to your " + name + ", and..."
							+ "\nWhoa. Whoa whoa whoa."
							+ "\nThis is incredible! YOU are incredible."
							+ "\nWith the " + value.getName() + " on your hat, your FASHION POINTS skyrockets!"
							+ "\nThe cowboy cosplay you never realized you had SOARS in VERISIMILITUDE."
							+ "\nYou rename your trusty hat the COWBOY HAT in celebration of this magnificent success.");
					name = "COWBOY HAT";
				} else {
					Output.print("You pin the " + value.getName() + " to your " + name + ".");
				}
			} else {
				Output.print("You already have the " + this.value.getName() + " in your " + name + ".");
			}
		} else {			
			super.assign(value);
		}
	}
	
	@Override
	public void remove() {
		if (value instanceof Badge && !hasTriedBadge) {
			Output.print("Yeah, this was pretty silly anyways."
					+ "\nYour " + name + " descends from its RAD COSPLAY status and returns to being a regular HAT.");
			name = "HAT";
			hasTriedBadge = true;
		}
		super.remove();
	}
	
	@Override
	public void use() {
		if (value == null) {
			Output.print("You have nothing in your " + name + ".");
		} else {			
			if (Runner.firstTryUseContainer) {			
				Output.print("Your " + name + " is a container. You cannot \"USE\" anything from within it."
						+ "\nInstead, it may be advisable to assign the " + value.getName() + " to one of your other keys, instead.");
				Runner.firstTryUseContainer = false;
			} else {
				Output.print("No matter how hard you try, you will be unable to USE anything from your " + name + ".");
			}
		}
	}
}

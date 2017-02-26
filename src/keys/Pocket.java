package keys;

import main.Runner;
import utilities.Output;

public class Pocket extends Key {
	
	public Pocket() {
		name = "POCKET";
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

package values;

import keys.KeyHat;
import main.Runner;
import utilities.Output;

public class Hat extends Value implements Heatable {
	
	@Override
	public String initName() {
		return "HAT";
	}
	
	@Override
	protected String checkText() {
		return "A high-crowned, wide-brimmed hat of audacious reputation."
				+ "\nYou recognize it to be your very own. The familiar, well-worn edges beckon.";
	}
	
	@Override
	public void use() {
		Output.print("You place the " + name + " onto your head."
				+ "\nWhile it sits atop your head, it functions as a KEY rather than a VALUE."
				+ "\nHence, your " + name + " now effectively acts as another container.");
		Runner.findKeyWithValue(this).remove();
		Runner.removeFromRoom(this);
		Runner.addToKeys(new KeyHat());
	}

	@Override
	public void heat(long timeInMillis) {
		if (timeInMillis < 15000) {
			Output.print("The " + name + " has become somewhat warm. It is comfortable to the touch, you suppose.");
		} else if (timeInMillis < 60000) {
			Output.print("The " + name + " has become lightly burnt. You fondly regard the crisped leather.");
		} else {
			Output.print("Oh wait, the " + name + " has caught fire! This is EXTREMELY ALARMING; you stomp it out immediately.");
		}
	}

}

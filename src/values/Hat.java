package values;

import keys.KeyHat;
import main.Runner;
import utilities.Output;

public class Hat extends Value {
	
	@Override
	protected void setName() {
		name = "HAT";
	}
	
	@Override
	protected void setCheckText() {
		checkText = "A high-crowned, wide-brimmed "+ name + " of audacious reputation."
				+ "\nYou recognize it to be your very own. The familiar, well-worn edges beckon.";
	}
	
	@Override
	public void use() {
		Output.print("You place the " + name + " onto your head."
				+ "\nWhile it sits atop your head, it functions as a KEY rather than a VALUE."
				+ "\nHence, your " + name + " now effectively acts as another container.");
		Runner.findKeyWithValue(this).remove();
		Runner.addToKeys(new KeyHat());
	}

}

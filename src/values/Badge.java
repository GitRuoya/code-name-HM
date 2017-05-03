package values;

import utilities.Output;

public class Badge extends Value {

	private boolean firstCheck;
	private boolean firstUse;
	
	public Badge() {
		super();
		firstCheck = true;
		firstUse = true;
	}
	
	@Override
	public void use() {
		if (firstUse) {			
			Output.print("The pin on the back of the " + name + " is too dull to be of good use."
						   + "\nThe tip most likely has worn with wear. Hang on, what? Pins don't \"wear out.\"");
			firstUse = false;
		} else {
			Output.print("On further consideration, it seems like the pin on the back was switched out with a dulled one."
					+ "\nUnluckily for you, there's no SEWING NEEDLE nearby to fix this weird and irrelevant plot hole.");
		}
	}

	@Override
	protected String initName() {
		return "SHERIFF BADGE";
	}

	@Override
	protected String checkText() {
		if (firstCheck) {			
			firstCheck = false;
			return "It looks to be one of those six-pointed sheriff stars that you always see in cowboy movies."
					+ "\nSpeaking of cowboy movies, you think still have the Rango blu-ray DVD at home."
					+ "\nOnce you're out of this situation, maybe you can go and rewatch that. FOR THE FIFTH TIME.";
		} else {
			return "Rango is probably your favorite motion movie picture of all time."
					+ "\nYou just really love the self-aware humor and plot that is going for it.";
		}
	}

}

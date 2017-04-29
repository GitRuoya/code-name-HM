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
						   + "\nThe tip most likely has worn with wear. Wait, what? Pins don't \"wear out.\"");
			firstUse = false;
		} else {
			Output.print("On further consideration, it seems like the pin was switched with a dulled one."
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
			return "It looks to be one of those six-pointed stars that you always see in cowboy movies."
					+ "\nSpeaking of cowboy movies, you think still have a Rango blu-ray DVD at home."
					+ "\nOnce you're out of this situation, maybe you can go and rewatch that.";
		} else {
			return "Rango is probably your favorite motion picture of all time."
					+ "\nYou really love the self-aware humor and plot that going for it.";
		}
	}

}

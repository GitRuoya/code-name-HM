package values;

import utilities.Output;

public class Marble extends Value {

	@Override
	public String initName() {
		return "MARBLE";
	}

	@Override
	protected String checkText() {
		return "It appears to be an ordinary, green marble."
				+ "\nYou wonder what a nice speciment like this is doing here, lying out in the open."
				+ "\nIt's almost a crime to leave such a beauty just sitting here.";
	}
	
	@Override
	public void use() {
		Output.print("You toy around with the " + name + " in your hand."
				+ "\nThe glassy surface is both smooth and round.");
	}

}

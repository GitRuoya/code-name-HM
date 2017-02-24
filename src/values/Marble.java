package values;

import utilities.Output;

public class Marble extends Value {

	public Marble() {
		name = "MARBLE";
	}
	
	@Override
	public void use() {
		Output.print("You toy around with the marble in your hand."
				+ "\nThe glassy surface is both smooth and round.");
	}

	@Override
	public void check() {
		Output.print("It appears to be an ordinary, green marble."
				+ "\nYou wonder what a nice speciment like this is doing here, lying out in the open."
				+ "\nIt's almost a crime to leave such a beauty just sitting here.");
	}

}

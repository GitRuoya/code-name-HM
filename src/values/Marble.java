package values;

public class Marble extends Value {

	public Marble() {
		name = "MARBLE";
	}
	
	@Override
	public String use() {
		// TODO Auto-generated method stub
		return "You toy around with the marble in your hand.\nThe glassy surface is both smooth and round.";
	}

	@Override
	public String check() {
		// TODO Auto-generated method stub
		return "It appears to be an ordinary, green marble."
				+ "\n...You wonder what a nice speciment like this is doing here, lying out in the open.";
	}

}

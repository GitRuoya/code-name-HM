package values;

import keys.Key;
import utilities.Output;

public abstract class Value implements Usable {

	public abstract String name();
	
	protected abstract String checkText();
	
	public void check() {
		Output.print(checkText());
	}
	
	public boolean canAssignTo(Key k) {
		return true;
	}
	
}

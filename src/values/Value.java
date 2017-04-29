package values;

import keys.Key;
import utilities.Output;

public abstract class Value implements Usable {
	
	protected String name = null;
	
	protected abstract String initName();
	protected abstract String checkText();
	
	public String getName() {
		if (name == null) {
			name = initName();
		}
		return name;
	}
	
	public void check() {
		Output.print(checkText());
	}
	
	public boolean canAssignTo(Key k) {
		return true;
	}
	
}

package values;

import keys.Key;
import utilities.Output;

public abstract class Value implements Usable {

	protected String name;
	protected String checkText;
	
	public Value() {
		setName();
		setCheckText();
	}
	
	protected abstract void setName();
	
	protected abstract void setCheckText();
	
	public void check() {
		Output.print(checkText);
	}
	
	public boolean canAssignTo(Key k) {
		return true;
	}
	
	public String getName() {
		return name;
	}
	
}

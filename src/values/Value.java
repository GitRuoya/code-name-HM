package values;

import keys.Key;

public abstract class Value implements Usable {

	protected String name;
	
	public abstract void check();
	
	public boolean canAssignTo(Key k) {
		return true;
	}
	
	public String getName() {
		return name;
	}
	
}

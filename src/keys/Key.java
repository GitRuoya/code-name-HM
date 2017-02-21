package keys;

import values.Value;

public class Key {
	
	protected Value value;
	protected String name;
	
	public String assign(Value value) {
		if (this.value == null) {
			this.value = value;
			return "You put the " + value.getName() + " in your " + name + ".";
		} else {
			return "You already have a " + value.getName() + " in your " + name + ".";
		}
	}

	public String use() {
		if (value == null) {
			return "You have nothing in your " + name + ".";
		} else {
			return value.use();
		}
	}
	
	public String remove() {
		if (value == null) {
			return "You have nothing in your " + name + ".";
		} else {
			return "You remove the " + value.getName() + " from your " + name + ".";
		}
	}
	
	public String getName() {
		return name;
	}
	public Value getValue() {
		return value;
	}
	
}

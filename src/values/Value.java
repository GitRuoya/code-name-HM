package values;

public abstract class Value implements Usable {

	protected String name;
	
	public abstract String check();
	
	public String getName() {
		return name;
	}

	
}

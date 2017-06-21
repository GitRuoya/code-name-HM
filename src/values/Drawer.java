package values;

import java.util.ArrayList;
import java.util.List;

import keys.Hand;
import keys.Key;
import main.Runner;
import utilities.Output;

public class Drawer extends Value {
	
	private List<Value> interior;
	private List<Value> currInterior;
	private boolean opened;
	private boolean firstClosed;
	
	public Drawer() {
		opened = false;
		interior = new ArrayList<Value>();
		currInterior = new ArrayList<Value>();
		firstClosed = true;
	}

	public Drawer(List<Value> interior) {
		super();
		opened = false;
		this.interior = interior;
		//currInterior has to be cloned.
		currInterior = new ArrayList<Value>();
		for (Value v: interior) {
			currInterior.add(v);
		}
		firstClosed = true;
	}
	
	@Override
	public String initName() {
		return "DRAWER HANDLE";
	}

	@Override
	protected String checkText() {
		if (!opened) {
			return "The drawer handle is affixed to a semi-custom drawer leaning against the back wall."
					+ "\nUnder the harsh light coming from the ceiling, a thin layer of dust is visible on the surface.";			
		} else {
			return "With the drawer opened, there seems nothing much left to do with this object."
					+ "\nYou stop and consider why you even bothered to INSPECT the " + name + " now that you've already USED it.";
		}
	}
	
	@Override
	public boolean canAssignTo(Key k) {
		if (k instanceof Hand) {
			return true;
		} else {
			Output.print("The "+ name + " is screwed onto the drawer, and refuses to be placed in your " + k.getName() + ".");
			return false;
		}
	}
	
	@Override
	public void use() {
		String values = "";
		int numItems = 0;
		for (Value v: interior) {
			if (!opened) {
				if (currInterior.contains(v)) {
					Runner.addToRoom(v);
					currInterior.remove(v);
					values = values + ", " + v.getName();
					numItems++;
				}
			} else {
				if (Runner.roomContains(v)) {
					Runner.removeFromRoom(v);
					currInterior.add(v);
					values = values + ", " + v.getName();
					numItems++;
				}
			}
		}
		if (numItems > 0) {
			values = values.substring(2);
		}
		if (!opened) {
			if (numItems > 1) {
				Output.print("You open the drawer, and reveal the following values: " + values + ".");
			} else if (numItems == 1) {
				Output.print("You open the drawer, and reveal a " + values + ".");
			} else {
				Output.print("You open the drawer, but guess what! Nothing's inside.");
			}
			opened = true;
		} else {
			if (numItems > 1) {
				Output.print("You close the drawer, conceiling the following values: " + values + ".");
			} else if (numItems == 1) {
				Output.print("You close the drawer, and conceil the " + values + ".");
			} else {
				if (firstClosed) {			
					Output.print("You close the drawer.");
				} else {
					Output.print("You close the drawer. Gee, how exciting.");	
				}
			}
			if (firstClosed && numItems > 0) {
				Output.print("Wait. Why did you just do THAT? You pause for a moment and contemplate this sudden regression of the plot.");
				firstClosed = false;
			}
			opened = false;
		}
	}
}

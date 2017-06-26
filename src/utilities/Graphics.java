package utilities;

import keys.Key;
import values.Value;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Graphics {

	// Fancy constants for html in the JLabel text.
	private static final String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
	private static final String FRONT = "<html><p style=\"font-family:courier\"><br>";
	private static final String BACK = "<br>&nbsp;</p></html>";
	
	private static JFrame window;
	private static JLabel inventory, room;
	
	public static void initializeWindow() {
		
		window = new JFrame();
		window.setLayout(new GridLayout());
		inventory = new JLabel();
		window.add(inventory);
		room = new JLabel();
		window.add(room);
		window.setVisible(true);
		
	}
	
	public static void update(List<Key> keys, List<Value> values) {
		inventory.setText(getInventoryText(keys));
		room.setText(getRoomText(values));
		window.pack();
	}
	

	private static String getRoomText(List<Value> values) {
		String labelText = "";
		
		for (Value v: values) {
			labelText = labelText + "<br>" + nbsp + v.getName() + nbsp;
		}
		
		return FRONT + nbsp + "<u>Room</u>" + labelText + BACK;
	}

	private static String getInventoryText(List<Key> keys) {
		String labelText = "";
		
		for (Key k: keys) {
			Value v = k.getValue();
			if (v == null) {
				labelText = labelText + "<br>" + nbsp + k.getName() + " -- N/A" + nbsp;
			} else {				
				labelText = labelText + "<br>" + nbsp + k.getName() + " -- " + k.getValue().getName() + nbsp;
			}
		}
		return FRONT + nbsp + "<u>Inventory</u>" + labelText + BACK;
	}
	
}

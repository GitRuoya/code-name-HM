import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import keys.Key;
import keys.RightHand;
import values.Marble;
import values.Value;

public class Runner {

	private static Scanner sc = new Scanner(System.in);
	
	private static List<Value> room = new ArrayList<Value>();
	private static List<Key> keys = new ArrayList<Key>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		keys.add(new RightHand());
		room.add(new Marble());
		playGame();
	}

	private static void playGame() {
		print("Welcome to [HM]"
		 + "\nYou are an elite computer scientist in the year 20XX. Your life in the outside world is comfortable, yet modest."
		 + "\nToday, as fortune would have it, you've become locked in a mysterious room."
		 + "\nType HELP to get the list of commands.");
		String input = getInput();
		while (!input.equals("HELP")) {
			print("You must type HELP to continue.");
			input = getInput();
		}
		print("As you are a self-proclaimed elite computer scientist, you only type in commands in ALL CAPS.");
		help();
		while (true) {
			input = getInput();
			String[] inputParts = input.split(" ");
			if (inputParts.length == 1) {
				if (input.equals("LIST")) {
					list();
				} else if (input.equals("HELP")) {
					help();
				} else {
					print("Invalid command.");
				}
			} else if (inputParts.length == 2) {
				if (input.equals("CHECK SURROUNDINGS")) {
					checkSurroundings();
				} else if (inputParts[0].equals("CHECK")) {
					check(inputParts[1]);
				} else {
					print("Invalid command.");
				}
			} else if (inputParts.length == 3) {
				if (inputParts[0].equals("USE") && inputParts[1].equals("FROM")) {
					use(inputParts[2]);
				} else if (inputParts[0].equals("REMOVE") && inputParts[1].equals("FROM")) {
					remove(inputParts[2]);
				} else {
					print("Invalid command.");
				}
			} else if (inputParts.length == 4 && inputParts[0].equals("ASSIGN") && inputParts[2].equals("TO")) {
				assign(inputParts[1], inputParts[3]);
			} else {
				print("Invalid command.");
			}
		}
	}
	
	private static void assign(String valueName, String keyName) {
		Key key = findKey(keyName);
		if (key != null) {
			Value value = findValue(valueName);			
			if (value != null) {
				room.remove(value);
				print(key.assign(value));
			}
		}
	}

	private static void remove(String keyName) {
		Key key = findKey(keyName);
		if (key != null) {
			if (key.getValue() != null) {				
				room.add(key.getValue());
			}
			print(key.remove());
		}
	}

	private static void use(String keyName) {
		Key key = findKey(keyName);
		if (key != null) {
			print(key.use());
		}
	}

	private static void check(String valueName) {
		Value value = findValue(valueName);
		if (value != null) {
			print(value.check());
		}
	}

	private static Key findKey (String keyName) {
		Key key = null;
		for (Key k: keys) {
			if (k.getName().equals(keyName)) {
				if (key == null) {
					key = k;
				} else {
					throw new RuntimeException();
				}
			}
		}
		if (key == null) {
			print("You have no key called \"" + keyName + "\""
					+ "\nUse the LIST command to consult your inventory and choose a key from there.");
		}
		return key;
	}
	
	private static Value findValue (String valueName) {
		Value value = null;
		for (Value v: room) {
			if (v.getName().equals(valueName)) {
				if (value == null) {
					value = v;
				} else {
					throw new RuntimeException();
				}
			}
		}
		if (value == null) {
			print("There is no \"" + valueName + "\" value in the room right now. Use the CHECK SURROUNDINGS command to see what is around you."
			 + "\nAlternatively, use the LIST command to check what you have in your inventory right now.");
		}
		return value;
	}
	
	private static void help() {
		print("Here are some templates to guide your commands:"
		 + "\n	CHECK SURROUNDINGS"
		 + "\n	CHECK [value]"
		 + "\n	ASSIGN [value] TO [key]"
		 + "\n	USE FROM [key]"
		 + "\n	REMOVE FROM [key]"
		 + "\n	LIST");
	}
	
	private static void checkSurroundings() {
		print("Currently, the room you're in consists of the following values:");
		for (Value v: room) {
			print("	" + v.getName());
		}		
	}
	
	private static void list() {
		print("Your inventory, as written by [key] --- [value]:");
		for (Key k: keys) {
			Value v = k.getValue();
			if (v == null) {
				print("	" + k.getName() + " --- NULL");
			} else {				
				print("	" + k.getName() + " --- " + k.getValue().getName());
			}
		}
	}
	
	private static void print(String text) {
		for (char s: text.toCharArray()) {
			System.out.print(s);
			try {
				if (s == ' ') {
					Thread.sleep(0);
				} else {					
					Thread.sleep(17);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
	private static String getInput() {
		return sc.nextLine();
	}
	
}

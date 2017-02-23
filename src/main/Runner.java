package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import keys.Key;
import keys.RightHand;
import utilities.Output;
import values.Marble;
import values.Value;

public class Runner {

	private static Scanner sc = new Scanner(System.in);
	
	private static List<Value> room = new ArrayList<Value>();
	private static List<Key> keys = new ArrayList<Key>();
	
	public static List<Value> getRoom() {
		return new ArrayList<Value>(room);
	}
	
	public static void addToRoom(Value v) {
		room.add(v);
	}
	
	public static void removeFromRoom(Value v) {
		if (room.contains(v)) {			
			room.remove(v);
		} else {
			throw new RuntimeException();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		keys.add(new RightHand());
		room.add(new Marble());
		playGame();
	}

	private static void playGame() {
		Output.print("Welcome to [HM]"
		 + "\nYou are an elite computer scientist in the year 20XX. Your life in the outside world is comfortable, yet modest."
		 + "\nToday, as fortune would have it, you've become locked in a mysterious room."
		 + "\nType HELP to get the list of commands.");
		String input = getInput();
		while (!input.equals("HELP")) {
			Output.print("You must type HELP to continue.");
			input = getInput();
		}
		Output.print("As you are a self-proclaimed elite computer scientist, you only type in commands in ALL CAPS.");
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
					Output.print("Invalid command.");
				}
			} else if (inputParts.length == 2) {
				if (input.equals("CHECK SURROUNDINGS")) {
					checkSurroundings();
				} else if (inputParts[0].equals("CHECK")) {
					check(inputParts[1]);
				} else {
					Output.print("Invalid command.");
				}
			} else if (inputParts.length == 3) {
				if (inputParts[0].equals("USE") && inputParts[1].equals("FROM")) {
					use(inputParts[2]);
				} else if (inputParts[0].equals("REMOVE") && inputParts[1].equals("FROM")) {
					remove(inputParts[2]);
				} else {
					Output.print("Invalid command.");
				}
			} else if (inputParts.length == 4 && inputParts[0].equals("ASSIGN") && inputParts[2].equals("TO")) {
				assign(inputParts[1], inputParts[3]);
			} else {
				Output.print("Invalid command.");
			}
		}
	}
	
	private static void assign(String valueName, String keyName) {
		Key key = findKey(keyName);
		if (key != null) {
			Value value = findValue(valueName);			
			if (value != null) {
				key.assign(value);
				//Printer.print(key.assign(value));
			}
		}
	}

	private static void remove(String keyName) {
		Key key = findKey(keyName);
		if (key != null) {
			key.remove();
		}
	}

	private static void use(String keyName) {
		Key key = findKey(keyName);
		if (key != null) {
			key.use();
		}
	}

	private static void check(String valueName) {
		Value value = findValue(valueName);
		if (value != null) {
			value.check();
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
			Output.print("You have no key called \"" + keyName + "\""
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
			Output.print("There is no \"" + valueName + "\" value in the room right now. Use the CHECK SURROUNDINGS command to see what is around you."
			 + "\nAlternatively, use the LIST command to check what you have in your inventory right now.");
		}
		return value;
	}
	
	private static void help() {
		Output.print("Here are some templates to guide your commands:"
		 + "\n	CHECK SURROUNDINGS"
		 + "\n	CHECK [value]"
		 + "\n	ASSIGN [value] TO [key]"
		 + "\n	USE FROM [key]"
		 + "\n	REMOVE FROM [key]"
		 + "\n	LIST");
	}
	
	private static void checkSurroundings() {
		Output.print("Currently, the room you're in consists of the following values:");
		for (Value v: room) {
			Output.print("	" + v.getName());
		}		
	}
	
	private static void list() {
		Output.print("Your inventory, as written by [key] --- [value]:");
		for (Key k: keys) {
			Value v = k.getValue();
			if (v == null) {
				Output.print("	" + k.getName() + " --- NULL");
			} else {				
				Output.print("	" + k.getName() + " --- " + k.getValue().getName());
			}
		}
	}
	
	private static String getInput() {
		return sc.nextLine();
	}
	
}

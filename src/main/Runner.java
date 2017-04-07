package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import keys.Key;
import keys.Pocket;
import keys.Hand;
import utilities.Output;
import values.DoorKnob;
import values.Hat;
import values.Marble;
import values.Value;

public class Runner {

	private static Scanner sc = new Scanner(System.in);
	
	private static List<Value> room = new ArrayList<Value>();
	private static List<Key> keys = new ArrayList<Key>();
	
	//Booleans that indicate whether it is the first time you tried something.
	//Note that if it is initialized as false, it should cause the event usually triggered by it to not occur at all.
	private static boolean firstList = true;
	private static boolean firstCheckSurroundings = true;
	public static boolean firstTryUseContainer = false;
	
	public static List<Value> getRoom() {
		return new ArrayList<Value>(room);
	}
	
	public static void addToRoom(Value v) {
		room.add(v);
	}
	
	public static void removeFromRoom(Value v) {
		room.remove(v);
	}
	
	public static Key findKeyWithValue(Value v) {
		for (Key k: keys) {
			if (k.getValue() == v) {
				return k;
			}
		}
		return null;
	}
	
	public static void addToKeys(Key k) {
		keys.add(k);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		keys.add(new Hand("RIGHT_HAND"));
		keys.add(new Hand("LEFT_HAND"));
		keys.add(new Pocket());
		
		room.add(new Marble());
		room.add(new DoorKnob());
		room.add(new Hat());
		
		playGame();
	}

	private static void playGame() {
		Output.print("Welcome to [HM]");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Output.print("You are an elite computer scientist in the year 20XX."
		 + "\nYour mastery over your proffesion is like none other, and not in the least because you've had no one else to compare it to."
		 + "\nToday, as fortune would have it, you've become locked in an unfamiliar room. The sole exit: a mysteriously locked door."
		 + "\nThe scenario strikes you as an extremely clichéd turn of events, but you ponder it no further."
		 + "\nType HELP to get the list of commands.");
		String input = getInput();
		while (!input.equals("HELP")) {
			Output.print("You must type HELP to continue.");
			input = getInput();
		}
		Output.print("As you are a self-proclaimed master computer scientist, you only type commands in ALL CAPS."
				+ "\nYou are fairly certain all professional programmers TYPE LIKE THIS.");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		help();
		Output.print("Try using the LIST command to check your inventory.");
		input = getInput();
		while (!input.equals("LIST")) {
			if (!input.equals(input.toUpperCase())) {
				Output.print("You are a MASTER PROGRAMMER, and know better than to try typing in lower case.");
			} else {				
				Output.print("That is not the LIST command!");
			}
			input = getInput();
		}
		list();
		while (true) {
			input = getInput();
			String[] inputParts = input.split(" ");
			if (inputParts.length == 1) {
				if (input.equals("LIST")) {
					list();
				} else if (input.equals("HELP")) {
					help();
				} else if (input.equals("QUIT")) {
					Output.print("Goodbye.");
					System.exit(0);
				} else {
					Output.print("Invalid command.");
				}
			} else if (inputParts.length == 2) {
				if (input.equals("LOOK AROUND")) {
					checkSurroundings();
				} else if (inputParts[0].equals("INSPECT")) {
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
			Output.print("There is no \"" + valueName + "\" value in the room right now. Use the LOOK AROUND command to inspect your surroundings.");
		}
		return value;
	}
	
	private static void help() {
		Output.print("Here are some templates to guide your commands:"
		 + "\n	LIST"
		 + "\n	LOOK AROUND"
		 + "\n	INSPECT [value]"
		 + "\n	ASSIGN [value] TO [key]"
		 + "\n	USE FROM [key]"
		 + "\n	REMOVE FROM [key]");
	}
	
	private static void checkSurroundings() {
		Output.print("Currently, the room you are in contains the following values:");
		for (Value v: room) {
			Output.print("	" + v.getName());
		}
		if (firstCheckSurroundings) {
			Output.print("Use the \"INSPECT [value]\" command to check any of the aforementioned objects.");
		}
	}
	
	private static void list() {
		if (firstList) {
			Output.print("You will only be able to act upon items stored in your inventory."
					+ "\nUse the \"ASSIGN [value] TO [key]\" command to put values in your possession.");
			firstList = false;
		}
		Output.print("Your current inventory, as written by [key] --- [value]:");
		for (Key k: keys) {
			Value v = k.getValue();
			if (v == null) {
				Output.print("	" + k.getName() + " --- N/A");
			} else {				
				Output.print("	" + k.getName() + " --- " + k.getValue().getName());
			}
		}
	}
	
	private static String getInput() {
		return sc.nextLine();
	}
	
}

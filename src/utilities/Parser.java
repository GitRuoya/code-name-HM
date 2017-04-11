package utilities;

public class Parser {

	// Given an input like "DARK CHOCOLATE IS BEST CHOCOLATE" and commands like "DARK", "BEST"
	// This method should return "CHOCOLATE IS", "CHOCOLATE"
	// Returns null if not all commands can be found in the input.
	// TODO: Make this work with commands that have spaces in them.
	public static String[] getArgs(String input, String... commands) {
		String[] pieces = input.split(" ");
		String[] args = new String[commands.length];
		
		int cmdIndex = 0;
		String nextCmd = commands[cmdIndex];
		String curr = "";
		for (int i = 0; i < pieces.length; i++) {
			String piece = pieces[i];
			if (piece.equals(nextCmd)) {
				if (cmdIndex != 0) {					
					args[cmdIndex-1] = curr;
				}
				cmdIndex++;
				if (cmdIndex < commands.length) {						
					nextCmd = commands[cmdIndex];
				}
				curr = "";
			} else {				
				if (curr.length() == 0) {
					curr = piece;
				} else {				
					curr = curr + " " + piece;
				}
			}
		}
		if (cmdIndex == commands.length) {
			args[cmdIndex-1] = curr;
			return args;
		} else {
			return null;			
		}
	}
	
}

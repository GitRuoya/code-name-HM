package utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestParser {

	@Test
	public void testGetArgs() {
		String input = "DARK CHOCOLATE IS BEST CHOCOLATE";
		String[] cmds = new String[]{"DARK", "BEST"};
		String[] args = new String[]{"CHOCOLATE IS", "CHOCOLATE"};
		assertArrayEquals(args, Parser.getArgs(input, cmds));
		
		cmds = new String[]{"DARK"};
		args = new String[]{"CHOCOLATE IS BEST CHOCOLATE"};
		assertArrayEquals(args, Parser.getArgs(input, cmds));
		
		cmds = new String[]{"DARK", "CHOCOLATE", "CHOCOLATE"};
		args = new String[]{"", "IS BEST", ""};
		assertArrayEquals(args, Parser.getArgs(input, cmds));

		cmds = new String[]{"CHOCOLATE", "MILK"};
		assertArrayEquals(null, Parser.getArgs(input, cmds));
	}

}

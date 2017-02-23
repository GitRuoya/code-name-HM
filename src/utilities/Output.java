package utilities;

public class Output {

	public static void print(String text) {
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
	
}

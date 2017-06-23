package utilities;

public class Output {

	private static int defaultBuffer = 24;
	private static boolean quickPrint = false;

	public static void setQuickPrint(boolean qp) {
		quickPrint = qp;
	}
	
	public static void print(String text) {
		print(text, defaultBuffer);
	}
	
	public static void setDefaultBuffer(int bufferTime) {
		defaultBuffer = bufferTime;
	}
	
	private static void print(String text, int bufferTime) {
		if (quickPrint) {
			System.out.println(text);
		} else {
			try {
				Thread.sleep(200);
				for (char s : text.toCharArray()) {
					System.out.print(s);
					if (s == ' ') {
						Thread.sleep(0);
					} else if (s == '\n') {
						Thread.sleep(300);
					} else {
						Thread.sleep(bufferTime);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}

}

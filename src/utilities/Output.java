package utilities;

public class Output {

	private static boolean quickPrint = false;

	public static void setQuickPrint(boolean qp) {
		quickPrint = qp;
	}
	
	public static void print(String text) {
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
						Thread.sleep(22);
					}
					// TODO Auto-generated catch block
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}

}

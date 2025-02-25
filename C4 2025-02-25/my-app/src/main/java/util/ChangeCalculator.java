package util;

public class ChangeCalculator {

	public static String calculateChange(int change) {
		int a = change / 1000;
		int b = (change - a * 1000) / 100;
		int c = (change - a * 1000 - b * 100) / 10;
		int d = change - a * 1000 - b * 100 - c * 10;

		return ("\n======================================" + "\n               找零: " + change + "元"
				+ "\n\t               1000元數量: " + a + "張" + "\n\t               100元數量: " + b + "張"
				+ "\n\t               10元數量: " + c + "個" + "\n\t               1元數量: " + d + "個");
	}
}

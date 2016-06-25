package testMethod;

public class Test {
	public static String padString(String oldStr, int strLen, char padChar,
			char direction) {
		String newStr = oldStr;
		try {
			if (oldStr.length() >= strLen) {
				newStr = oldStr;
			} else {
				if (direction == 'r') {
					while (newStr.length() < strLen) {
						newStr = newStr + padChar;
					}
				} else {
					while (newStr.length() < strLen) {
						newStr = padChar + newStr;
					}
				}
			}
			return newStr;
		} catch (Exception e) {
			return oldStr;
		}
	}
	
	public static void main(String[] args) {
		String oldStr = "33721144";
		String newStr = "";
		newStr = Test.padString(oldStr, 19, '4', '1');
		System.out.println(newStr);
	}
}

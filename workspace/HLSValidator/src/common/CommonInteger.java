package common;

public class CommonInteger {

	public static Boolean tryParse(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}

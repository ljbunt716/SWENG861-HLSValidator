package common;

public class CommonFloat {

	public static Boolean tryParse(String value) {
		try {
			Float.parseFloat(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}

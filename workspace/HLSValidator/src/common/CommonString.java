package common;

import java.util.List;

public class CommonString {

	// Converts a List<String> to a comma separated string
	public static String GetCommaSeparatedString(List<String> stringList) {
		StringBuilder sb = new StringBuilder();

		for (String string : stringList) {
			sb.append(string).append(",");
		}

		// Remove the last comma
		return RemoveLastCharachter(sb.toString());
	}

	public static String RemoveLastCharachter(String str) {
		return str.substring(0, str.length() - 1);
	}
}
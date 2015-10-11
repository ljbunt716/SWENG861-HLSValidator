package common;

import java.util.Arrays;
import java.util.List;

public class CommonList {

	public static List<String> SplitOnNewLine(String text) {
		return Arrays.asList(text.split("\\n"));
	}
}

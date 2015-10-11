package validators.Common;

import java.util.Arrays;
import java.util.List;

public class CaseValidator {

	public static Boolean IsValidCase(String wholeString, String stringToValidate) {

		// Split string based on case provided.
		// Then do check if string is within text, if it is than case is
		// incorrect
		try {
			List<String> allWordsInFile = Arrays.asList(wholeString.split(stringToValidate));
			for (String word : allWordsInFile) {
				if (word.toLowerCase().contains(stringToValidate.toLowerCase()))
					return false;
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
package validators.EXTINF;

import java.util.Arrays;
import java.util.List;

import common.CommonFloat;
import common.CommonInteger;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;
import validators.EXTXVERSION.EXTXVERSIONValidator;

//Duration is a decimal-integer or decimal-floating-point number
// Always use floating point EXTINF durations (supported in protocol version 3).
public class ValidateEXTINFValueValidator extends Validator {

	public ValidateEXTINFValueValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		int lineNumber = 0;

		try {
			List<String> allLinesInFile = Arrays.asList(File.HLSText.split("\\n"));
			int extVersion = EXTXVERSIONValidator.GetEXTVersionValue(allLinesInFile);

			for (String line : allLinesInFile) {
				lineNumber++;
				if (line.startsWith("#EXTINF")) {
					String value = line.substring(line.indexOf("#EXTINF:") + 8, line.indexOf(","));// +8
																									// to
																									// remove
																									// #EXTINF:

					// Validate value is either Integer or Float
					// Files with Version # < 3 MUST be integer
					if (extVersion < 3) {
						if (!CommonInteger.tryParse(value)) {
							super.AddValidationError(
									"#EXTINF: has invalid Value - " + value
											+ " Version Number < 3 so value must be integer.",
									"Invalid #EXTINF Value Validation", lineNumber);
						}
					} else if (extVersion >= 3) {
						if (!CommonFloat.tryParse(value) || CommonInteger.tryParse(value))
							super.AddValidationError(
									"#EXTINF: has invalid Value - " + value
											+ ", Version Number >= 3 so value must be floating point.",
									"Invalid #EXTINF Value Validation", lineNumber);
					}
				}
			}
		} catch (Exception e) {
			super.AddValidationError("#EXTINF: has invalid Value: ", "Invalid #EXTINF Duration Value Validation");
		}
	}
}
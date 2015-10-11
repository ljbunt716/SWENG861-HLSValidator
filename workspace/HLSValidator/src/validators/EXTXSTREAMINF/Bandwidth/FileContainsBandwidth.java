package validators.EXTXSTREAMINF.Bandwidth;

import java.util.List;

import common.CommonList;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//   Every EXT-X-STREAM-INF tag MUST include the BANDWIDTH attribute.
public class FileContainsBandwidth extends Validator {
	public FileContainsBandwidth(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		int lineNumber = 0;

		try {
			List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);
			for (String line : allLinesInFile) {
				lineNumber++;
				if (line.startsWith("#EXT-X-STREAM-INF:")) {
					if (!line.contains("BANDWIDTH"))
						AddErrorMessage(lineNumber);
				}
			}

		} catch (Exception e) {
			super.AddValidationError("EXT-X-STREAM-INF line is missing BANDWIDTH tag: ",
					"Missing BANDWIDTH tag Validation");
		}

	}

	private void AddErrorMessage(int lineNumber) {
		super.AddValidationError("EXT-X-STREAM-INF is missing BANDWIDTH tag: ", "Missing BANDWIDTH tag Validation",
				lineNumber);
	}
}

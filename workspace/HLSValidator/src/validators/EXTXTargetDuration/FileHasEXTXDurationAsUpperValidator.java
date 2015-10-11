package validators.EXTXTargetDuration;

import java.util.List;

import common.CommonList;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;
import validators.Common.CaseValidator;

public class FileHasEXTXDurationAsUpperValidator extends Validator {

	public FileHasEXTXDurationAsUpperValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {

		List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);
		int lineNumber = 0;

		for (String line : allLinesInFile) {
			lineNumber++;

			if (line.toLowerCase().contains("targetduration")) {
				if (!CaseValidator.IsValidCase(line, "#EXT-X-TARGETDURATION"))
					super.AddValidationError("#EXT-X-TARGETDURATION is not Uppercase : " + line,
							"File Has #EXT-X-TARGETDURATION Uppercase Validation", lineNumber);
			}
		}
	}
}

package validators.EXTXENDLIST;

import java.util.List;

import common.CommonList;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;
import validators.Common.CaseValidator;

//#EXT-X-ENDLIST must be Uppercase
public class EXTXENDLISTIsUpperValidator extends Validator {

	public EXTXENDLISTIsUpperValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);
		int lineNumber = 0;

		for (String line : allLinesInFile) {
			lineNumber++;

			if (line.toLowerCase().contains("endlist")) {
				if (!CaseValidator.IsValidCase(line, "#EXT-X-ENDLIST"))
					super.AddValidationError("#EXT-X-ENDLIST tag is not Uppercase: " + line,
							"File Has #EXT-X-ENDLIST Uppercase Validation", lineNumber);
			}
		}

	}
}

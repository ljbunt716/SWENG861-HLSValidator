package validators;

import java.util.List;

import common.CommonList;
import hlsfiles.HLSFileWDirectory;
import validators.Common.CaseValidator;

//#EXT part of tag must be Uppercase
public class FileHasEXTAsUpperValidator extends Validator {

	public FileHasEXTAsUpperValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {

		List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);
		int lineNumber = 0;

		for (String line : allLinesInFile) {
			lineNumber++;

			if (!CaseValidator.IsValidCase(line, "#EXT"))
				super.AddValidationError("#EXT Tag is not Uppercase.", "File Has #EXT tag Uppercase Validation",
						lineNumber);

		}
	}
}

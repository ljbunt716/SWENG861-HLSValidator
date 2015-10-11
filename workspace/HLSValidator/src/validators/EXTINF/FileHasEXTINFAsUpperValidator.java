package validators.EXTINF;

import java.util.List;

import common.CommonList;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;
import validators.Common.CaseValidator;

//Its format is: #EXTINF:<duration>[,<title>]
public class FileHasEXTINFAsUpperValidator extends Validator {

	public FileHasEXTINFAsUpperValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);
		int lineNumber = 0;

		for (String line : allLinesInFile) {
			lineNumber++;

			if (!CaseValidator.IsValidCase(line, "#EXTINF"))
				super.AddValidationError("#EXTINF Tag is not Uppercase.", "File Has #EXTINF tag Uppercase Validation",
						lineNumber);

		}
	}
}

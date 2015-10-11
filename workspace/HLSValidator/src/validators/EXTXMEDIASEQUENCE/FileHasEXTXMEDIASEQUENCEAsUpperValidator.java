package validators.EXTXMEDIASEQUENCE;

import java.util.List;

import common.CommonList;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;
import validators.Common.CaseValidator;

//   #EXT-X-MEDIA-SEQUENCE: must be Uppercase
public class FileHasEXTXMEDIASEQUENCEAsUpperValidator extends Validator {

	public FileHasEXTXMEDIASEQUENCEAsUpperValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);
		int lineNumber = 0;

		for (String line : allLinesInFile) {
			lineNumber++;

			if (line.toLowerCase().contains("media-sequence")) {
				if (!CaseValidator.IsValidCase(line, "#EXT-X-MEDIA-SEQUENCE"))
					super.AddValidationError("#EXT-X-MEDIA-SEQUENCE is not Uppercase : " + line,
							"File Has #EXT-X-MEDIA-SEQUENCE Uppercase Validation", lineNumber);
			}
		}
	}
}

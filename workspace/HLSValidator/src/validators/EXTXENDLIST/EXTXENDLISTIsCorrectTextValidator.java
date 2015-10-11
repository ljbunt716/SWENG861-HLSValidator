package validators.EXTXENDLIST;

import java.util.List;

import common.CommonList;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//#EXT-X-ENDLIST tag MUST contain proper tag text
public class EXTXENDLISTIsCorrectTextValidator extends Validator {

	public EXTXENDLISTIsCorrectTextValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);
		int lineNumber = 0;

		for (String line : allLinesInFile) {
			lineNumber++;

			if (line.toLowerCase().contains("endlist")) {
				if (!line.toLowerCase().equals("#ext-x-endlist")) {
					super.AddValidationError("Tag #EXT-X-ENDLIST in file is not in correct format: " + line,
							"File Has Invalid #EXT-X-ENDLIST Tag", lineNumber);
				}
			}
		}
	}
}

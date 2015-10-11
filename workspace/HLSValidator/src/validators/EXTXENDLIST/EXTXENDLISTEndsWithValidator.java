package validators.EXTXENDLIST;

import java.util.List;

import common.CommonList;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;

public class EXTXENDLISTEndsWithValidator extends Validator {

	public EXTXENDLISTEndsWithValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		try {
			List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);

			int lineNumber = allLinesInFile.size() - 1;
			String lastLine = allLinesInFile.get(lineNumber);

			if (!lastLine.equals("#EXT-X-ENDLIST")) {
				super.AddValidationError("File does not end with #EXT-X-ENDLIST tag.", "Invalid closing tag.",
						lineNumber + 1);
			}
		} catch (Exception e) {
			super.AddValidationError("File does not end with #EXT-X-ENDLIST tag.", "Invalid closing tag.");
		}
	}
}

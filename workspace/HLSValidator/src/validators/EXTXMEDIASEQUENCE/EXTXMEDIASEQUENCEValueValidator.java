package validators.EXTXMEDIASEQUENCE;

import java.util.List;

import common.CommonInteger;
import common.CommonList;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;

// #EXT-X-MEDIA-SEQUENCE:<number> where number is a decimal-integer.
public class EXTXMEDIASEQUENCEValueValidator extends Validator {

	public EXTXMEDIASEQUENCEValueValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {

		List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);
		String mediaSequenceValue = GetMediaSequenceValue(allLinesInFile);
		int lineNumber = GetMediaSequenceValueLineNumber(allLinesInFile);

		if (!CommonInteger.tryParse(mediaSequenceValue))
			super.AddValidationError("File contains incorrect #EXT-X-MEDIA-SEQUENCE Value - " + mediaSequenceValue,
					"#EXT-X-MEDIA-SEQUENCE Value Validation", lineNumber);

	}

	public static String GetMediaSequenceValue(List<String> allLinesInFile) {
		for (String line : allLinesInFile) {
			if (line.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
				return line.split(":")[1].trim();
			}
		}

		return "";
	}

	public static int GetMediaSequenceValueLineNumber(List<String> allLinesInFile) {
		int lineNumber = 0;

		for (String line : allLinesInFile) {
			lineNumber++;

			if (line.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
				return lineNumber;
			}
		}

		return 0;
	}
}

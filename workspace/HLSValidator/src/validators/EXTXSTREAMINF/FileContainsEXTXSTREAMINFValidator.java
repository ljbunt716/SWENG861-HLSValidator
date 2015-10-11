package validators.EXTXSTREAMINF;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//#EXT-X-STREAM-INF: tag is required.
public class FileContainsEXTXSTREAMINFValidator extends Validator {
	public FileContainsEXTXSTREAMINFValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		try {
			if (!File.HLSText.contains("#EXT-X-STREAM-INF:"))
				AddErrorMessage();
		} catch (Exception e) {
			AddErrorMessage();
		}
	}

	private void AddErrorMessage() {
		super.AddValidationError("File is missing line: #EXT-X-STREAM-INF: ",
				"File Missing #EXT-X-STREAM-INF Validation");
	}
}
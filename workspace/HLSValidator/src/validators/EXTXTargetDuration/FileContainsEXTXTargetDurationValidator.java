package validators.EXTXTargetDuration;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//The EXT-X-TARGETDURATION tag is REQUIRED.
public class FileContainsEXTXTargetDurationValidator extends Validator {

	public FileContainsEXTXTargetDurationValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		if (!File.HLSText.contains("#EXT-X-TARGETDURATION:"))
			super.AddValidationError("File is missing #EXT-X-TARGETDURATION Tag ",
					"Missing #EXT-X-TARGETDURATION Tag Validation");

	}
}
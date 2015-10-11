package validators.EXTINF;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//The EXTINF tag specifies the duration of a Media Segment.  It applies only to the next Media Segment.  
//This tag is REQUIRED for each Media Segment.
public class FileContainsEXTINFValidator extends Validator {

	public FileContainsEXTINFValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {

		try {
			if (!File.HLSText.contains("#EXTINF:"))
				AddErrorMessage();

		} catch (Exception e) {
			AddErrorMessage();
		}

	}

	private void AddErrorMessage() {
		super.AddValidationError("File is missing tag - #EXTINF:", "Missing #EXTINF: tag Validation");
	}
}

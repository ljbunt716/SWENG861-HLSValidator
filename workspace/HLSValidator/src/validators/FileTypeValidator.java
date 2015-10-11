package validators;

import hlsfiles.HLSFileWDirectory;

//In the first case, the path MUST end with either.m3u8 or.m3u.

public class FileTypeValidator extends Validator {

	public FileTypeValidator(HLSFileWDirectory file) {
		File = file;
	}

	public Boolean IsValid() {
		Boolean isValidExtension = false;
		try {
			isValidExtension = File.FileExtension.equals("m3u8") || File.FileExtension.equals("m3u");
			if (!isValidExtension)
				AddErrorMessage();
		} catch (Exception e) {
			AddErrorMessage();
		}

		return isValidExtension;
	}

	private void AddErrorMessage() {
		super.AddValidationError("File Extension is Incorrect for File: " + File.FileName, "File Type Validation");
	}
}

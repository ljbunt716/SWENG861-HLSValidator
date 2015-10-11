package validators.MediaURI;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//Validate Media URI's
public class MediaURIValidator extends Validator {

	public MediaURIValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		// Step 1 - Validate all Media URI's are incremented by 1
		ValidateMediaURIOccursOnce();

		// Step 2 - Validate Media URI in proper order
		ValidateMediaURIOrder();
	}

	// #region Validators
	private void ValidateMediaURIOccursOnce() {
		MediaURIOccurenceValidator occurence = new MediaURIOccurenceValidator(File);
		occurence.Validate();
	}

	private void ValidateMediaURIOrder() {
		MediaURIOrderValidator order = new MediaURIOrderValidator(File);
		order.Validate();
	}

	// #endregion
}

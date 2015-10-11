package validators.EXTXTargetDuration;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//Validate EXT-X-TARGETDURATION tag
public class EXTTargetDurationValidator extends Validator {

	public EXTTargetDurationValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		// Step 1 - Validate EXT-X-TARGETDURATION exists
		ValidateEXTXTargetDurationExists();

		// Step 2- Validate #EXT-X-TARGETDURATION is Uppercase
		ValidateEXTXDurationTagIsUpperCase();

		// Step 3 - Validate #EXT-X-TARGETDURATION value is Valid
		ValidateEXTXDuratonValueIsValid();

	}

	// #region - Validators

	private void ValidateEXTXTargetDurationExists() {
		FileContainsEXTXTargetDurationValidator targetDuration = new FileContainsEXTXTargetDurationValidator(File);
		targetDuration.Validate();
	}

	private void ValidateEXTXDurationTagIsUpperCase() {
		FileHasEXTXDurationAsUpperValidator extxdurationIsUpper = new FileHasEXTXDurationAsUpperValidator(File);
		extxdurationIsUpper.Validate();
	}

	private void ValidateEXTXDuratonValueIsValid() {
		EXTXTargetDurationValueValidator validValue = new EXTXTargetDurationValueValidator(File);
		validValue.Validate();
	}

	// #endregion

}
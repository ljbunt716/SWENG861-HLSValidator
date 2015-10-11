package validators.EXTXENDLIST;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//Validate #EXT-X-ENDLIST tag
public class EXTXENDLISTValidators extends Validator {

	public EXTXENDLISTValidators(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {

		// Step 1 - Validate file ends with #EXT-X-ENDLIST
		EXTXENDLISTEndsWithValidator();

		// Step 2 - Validate #EXT-X-ENDLIST tag text is correct
		ValidateEXTXENDLISTIsCorrectText();

		// Step 3 - Validate #EXT-X-ENDLIST is UPPER
		ValidateEXTXENDLISTIsUpper();

	}

	// #region - Validators
	private void EXTXENDLISTEndsWithValidator() {
		EXTXENDLISTEndsWithValidator endsWith = new EXTXENDLISTEndsWithValidator(File);
		endsWith.Validate();
	}

	private void ValidateEXTXENDLISTIsCorrectText() {
		EXTXENDLISTIsCorrectTextValidator isCorrectText = new EXTXENDLISTIsCorrectTextValidator(File);
		isCorrectText.Validate();
	}

	private void ValidateEXTXENDLISTIsUpper() {
		EXTXENDLISTIsUpperValidator isUpper = new EXTXENDLISTIsUpperValidator(File);
		isUpper.Validate();
	}

	// #endregion
}
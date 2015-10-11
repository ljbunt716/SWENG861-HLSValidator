package validators.EXTXSTREAMINF;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;
import validators.EXTXSTREAMINF.Bandwidth.BandwidthValidator;

//Validate #EXT-X-STREAM-INF tag
public class EXTXSTREAMINFValidator extends Validator {

	public EXTXSTREAMINFValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {

		// Step 1 - Validate EXT-X-STREAM-INF line exists
		ValidateEXTXSTREAMINFExists();

		// Step 2 - Validate EXT-X-STREAM-INF line contains bandwidth, if so
		// validate the Bandwidth
		ValidateBandwidth();
	}

	// #region Validators
	private void ValidateEXTXSTREAMINFExists() {
		FileContainsEXTXSTREAMINFValidator fileContainsEXTXSTREAMINF = new FileContainsEXTXSTREAMINFValidator(File);
		fileContainsEXTXSTREAMINF.Validate();
	}

	private void ValidateBandwidth() {
		BandwidthValidator validateBandwidth = new BandwidthValidator(File);
		validateBandwidth.Validate();
	}
	// #endregion
}

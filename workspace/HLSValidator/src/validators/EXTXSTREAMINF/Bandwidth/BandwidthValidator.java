package validators.EXTXSTREAMINF.Bandwidth;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//Validate Bandwidth part of #EXT-X-STREAM-INF tag
public class BandwidthValidator extends Validator {

	public BandwidthValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {

		// Step 1 - Validate Bandwidth exists
		ValidateBandwidthExists();

		// Step 2 - Validate Bandwidth value is decimal-integer
		ValidateBandwidthValue();
	}

	// #region Validators
	private void ValidateBandwidthExists() {
		FileContainsBandwidth fileContainsBandwidth = new FileContainsBandwidth(File);
		fileContainsBandwidth.Validate();
	}

	private void ValidateBandwidthValue() {
		BandwidthValueValidator bandwidthValue = new BandwidthValueValidator(File);
		bandwidthValue.Validate();
	}
	// #endregion

}

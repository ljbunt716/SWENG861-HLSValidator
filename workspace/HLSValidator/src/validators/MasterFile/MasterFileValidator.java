package validators.MasterFile;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;
import validators.EXTXSTREAMINF.EXTXSTREAMINFValidator;

//Do validations on items only pertaining to Master Files
public class MasterFileValidator extends Validator {

	public MasterFileValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		
		// Step 1 - Validate EXT-X-STREAM-INF line
		ValidateEXTXSTREAMINF();
	}

	private void ValidateEXTXSTREAMINF() {
		EXTXSTREAMINFValidator EXTXSTREAMINF = new EXTXSTREAMINFValidator(File);
		EXTXSTREAMINF.Validate();
	}
}

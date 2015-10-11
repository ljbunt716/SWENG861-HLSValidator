package validators.EXTXVERSION;

import java.util.List;

import common.CommonInteger;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//Validate #EXT-X-VERSION: tag
public class EXTXVERSIONValidator extends Validator {

	public EXTXVERSIONValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {

		// Step 1 -Validate file has ONLY 1 version #
		ValidateOneVersionExists();

		// Step 2 - Validate version number is integer
		ValidateVersionNumberIsValid();

	}

	// #region - Validators

	private void ValidateOneVersionExists() {
		FileContainsOneEXTXVERSIONTagValidator oneVersionTag = new FileContainsOneEXTXVERSIONTagValidator(File);
		oneVersionTag.Validate();
	}

	private void ValidateVersionNumberIsValid() {
		FileContainsValidVersionNumberValidator versionNumber = new FileContainsValidVersionNumberValidator(File);
		versionNumber.Validate();
	}

	// #endregion

	public static int GetEXTVersionValue(List<String> allLinesInFile) {
		for (String line : allLinesInFile) {
			if (line.startsWith("#EXT-X-VERSION")) {
				String versionNumber = line.split(":")[1].trim();
				if (CommonInteger.tryParse(versionNumber))
					return Integer.parseInt(versionNumber);
			}
		}

		return 0;
	}

}

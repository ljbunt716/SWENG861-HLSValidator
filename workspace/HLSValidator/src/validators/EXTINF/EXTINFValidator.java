package validators.EXTINF;

import java.util.ArrayList;
import java.util.List;

import common.CommonInteger;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//Validate #EXTINF tag
public class EXTINFValidator extends Validator {

	public EXTINFValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		// Step 1 - Validate file contains EXTINF tag
		ValidateEXTINFExists();

		// Step 2 - Validate EXTINF case
		ValidateEXTINFCase();

		// Step 3 - Validate EXTINF Value
		ValidateEXTINFValue();
	}

	// #region - Validators
	private void ValidateEXTINFExists() {
		FileContainsEXTINFValidator extinfExists = new FileContainsEXTINFValidator(File);
		extinfExists.Validate();
	}

	private void ValidateEXTINFCase() {
		FileHasEXTINFAsUpperValidator extinfCase = new FileHasEXTINFAsUpperValidator(File);
		extinfCase.Validate();
	}

	private void ValidateEXTINFValue() {
		ValidateEXTINFValueValidator extinfValue = new ValidateEXTINFValueValidator(File);
		extinfValue.Validate();
	}

	// #endregion

	public static int GetEXTINFValue(List<String> allLinesInFile) {
		for (String line : allLinesInFile) {
			if (line.startsWith("#EXTINF")) {
				String extinfValue = line.split(":")[1].split(",")[0].trim();
				if (CommonInteger.tryParse(extinfValue))
					return Integer.parseInt(extinfValue);
			}
		}

		return 0;
	}

	public static List<Integer> GetEXTINFValues(List<String> allLinesInFile) {
		List<Integer> infValues = new ArrayList<Integer>();

		for (String line : allLinesInFile) {
			if (line.startsWith("#EXTINF")) {
				String extinfValue = line.split(":")[1].split(",")[0].trim();
				if (CommonInteger.tryParse(extinfValue))
					infValues.add(Integer.parseInt(extinfValue));
			}
		}

		return infValues;
	}
}

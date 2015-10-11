package validators.EXTXSTREAMINF.Bandwidth;

import java.util.List;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;
import common.CommonInteger;
import common.CommonList;

//BANDWIDTH - The value is a decimal-integer of bits per second.
public class BandwidthValueValidator extends Validator {

	public BandwidthValueValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		int lineNumber = 0;

		try {
			List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);
			for (String line : allLinesInFile) {
				lineNumber++;
				if (line.startsWith("#EXT-X-STREAM-INF:")) {
					if (line.contains("BANDWIDTH")) {
						String bandwidthValue = line.substring(line.indexOf("BANDWIDTH=") + 10, line.length());// +10
						// to
						// remove
						// BANDWIDTH=
						if (!CommonInteger.tryParse(bandwidthValue))
							AddErrorMessage(lineNumber, bandwidthValue);
					}

				}
			}
		} catch (Exception e) {
			super.AddValidationError("EXT-X-STREAM-INF has invalid BANDWIDTH value: ",
					"Invalid BANDWIDTH value Validation");
		}
	}

	private void AddErrorMessage(int lineNumber, String value) {
		super.AddValidationError("EXT-X-STREAM-INF has invalid BANDWIDTH value - " + value + ".",
				"Invalid BANDWIDTH Value Validation", lineNumber);
	}

}

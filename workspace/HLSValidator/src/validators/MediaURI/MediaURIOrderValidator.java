package validators.MediaURI;

import java.util.Arrays;
import java.util.List;

import common.CommonInteger;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//The EXT-X-MEDIA-SEQUENCE tag value MUST be incremented by 1 for every media URI that is removed from the playlist file. 
//Media URIs must be removed from the playlist file in the order that they appear in the playlist. 
//The updated index file presents a moving window into a continuous stream. This type of session is suitable for continuous broadcasts.
public class MediaURIOrderValidator extends Validator {

	public MediaURIOrderValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		int prevVal = -1;
		int lineNumber = 0;

		List<String> allLinesInFile = Arrays.asList(File.HLSText.split("\\n"));
		for (String line : allLinesInFile) {
			lineNumber++;
			if (!line.startsWith("#")) {

				String uriVal = line.substring(0, line.lastIndexOf('.')).substring(line.lastIndexOf('_') + 1);
				if (CommonInteger.tryParse(uriVal)) {
					int mediaURIVal = Integer.parseInt(uriVal);

					// If first file, set it to value of media URI minus 1
					if (prevVal == -1)
						prevVal = mediaURIVal - 1;

					if (prevVal + 1 != mediaURIVal) {
						super.AddValidationError("Media URI values are not incremented by 1: Previous Value - "
								+ prevVal + " New Value - " + mediaURIVal, "Media URI not incremented by 1",
								lineNumber);
					}

					prevVal = mediaURIVal;
				}

			}
		}

	}

}

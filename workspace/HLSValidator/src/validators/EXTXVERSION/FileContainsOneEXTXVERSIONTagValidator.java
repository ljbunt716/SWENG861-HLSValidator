package validators.EXTXVERSION;

import java.util.ArrayList;
import java.util.List;

import common.CommonList;
import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//   A Playlist file MUST NOT contain more than one EXT-X-VERSION tag.
public class FileContainsOneEXTXVERSIONTagValidator extends Validator {

	public FileContainsOneEXTXVERSIONTagValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {

		try {
			List<String> allLinesInFile = CommonList.SplitOnNewLine(File.HLSText);
			int versionCount = GetVersionNumberCount(allLinesInFile);

			if (versionCount < 1)
				super.AddValidationError("File is missing #EXT-X-VERSION: ", "Missing #EXT-X-VERSION Validation");
			else if (versionCount > 1)
				super.AddValidationError("File has more than one #EXT-X-VERSION: Tag ",
						"Multiple #EXT-X-VERSION Tag Validation");

		} catch (Exception e) {
			super.AddValidationError("File is missing #EXT-X-VERSION: ", "Missing #EXT-X-VERSION Validation");
		}
	}

	private int GetVersionNumberCount(List<String> allLinesInFile) {
		List<String> versionLines = new ArrayList<String>();

		for (String line : allLinesInFile) {

			if (line.startsWith("#EXT-X-VERSION:"))
				versionLines.add(line);
		}

		return versionLines.size();
	}

}

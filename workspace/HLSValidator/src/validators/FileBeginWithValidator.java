package validators;

import hlsfiles.HLSFileWDirectory;

//The EXTM3U tag indicates that the file is an Extended M3U [M3U]Playlist file.  
//It MUST be the first line of every Media Playlist and every Master Playlist.
public class FileBeginWithValidator extends Validator {

	public FileBeginWithValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		String s = new String(File.HLSText);

		try {
			if (!s.startsWith("#EXTM3U"))
				AddErrorMessage();
		} catch (Exception e) {
			AddErrorMessage();
		}
	}

	private void AddErrorMessage() {
		super.AddValidationError("File does not begin with correct tag (#EXTM3U) : ",
				"File Begins With #EXTM3U Validation", 1);
	}

}

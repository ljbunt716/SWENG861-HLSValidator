package validators.MediaURI;

import java.util.ArrayList;
import java.util.List;

import hlsfiles.HLSFileWDirectory;
import validators.Validator;

//Each MediaURI should only appear once
public class MediaURIOccurenceValidator extends Validator {

	public MediaURIOccurenceValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {

		List<String> allURI = new ArrayList<String>();

		for (String mediaURI : File.MediaURIs) {
			if (!allURI.contains(mediaURI)) {
				allURI.add(mediaURI);
			} else {
				super.AddValidationError("Media URI values are not unique: MediaURI:" + mediaURI, "Duplicate MediaURI");
			}
		}

	}

}

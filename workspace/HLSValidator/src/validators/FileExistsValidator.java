package validators;

import java.net.HttpURLConnection;
import java.net.URL;
import common.CommonFile;
import hlsfiles.HLSDirectory;
import hlsfiles.HLSFileType;
import hlsfiles.HLSFileWDirectory;

//All Files within Master/Media file must exist within directory
public class FileExistsValidator extends Validator {

	public FileExistsValidator(HLSFileWDirectory file) {
		File = file;
	}

	public void Validate() {
		for (String lowerLevelFile : File.MediaURIs) {
			if (!DoesFileExist(File.Directory.DirectoryPath, lowerLevelFile, File.Type)) {
				super.AddValidationError("File is missing from Directory: " + lowerLevelFile,
						"File Missing Validation");
			}
		}
	}

	public Boolean DoesFileExist(String directory, String fileName, HLSFileType.Type type) {

		String pathName = CommonFile.PathCombine(directory, fileName);
		return DoesFileExist(pathName, type);
	}

	public static Boolean DoesFileExist(String pathName) {
		HLSFileType.Type type = HLSFileType.GetFileType(pathName);
		return DoesFileExist(pathName, type);
	}

	public static Boolean DoesFileExist(String pathName, HLSFileType.Type type) {
		pathName = HLSDirectory.GetFileDirectoryPath(pathName, type);
		try {
			if (type.equals(HLSFileType.Type.URL)) {
				// Process as URL
				URL url = new URL(pathName.replace("\\", "//"));
				HttpURLConnection.setFollowRedirects(false);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("HEAD");

				return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
			} else {
				// Process as a File
				java.io.File f = new java.io.File(pathName);
				return (f.exists() && !f.isDirectory());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}

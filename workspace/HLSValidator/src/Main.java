import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import common.CommonFile;
import hlsfiles.HLSFileType;
import hlsfiles.HLSFileWDirectory;
import validators.FileExistsValidator;
import validators.Validator;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		// For Production
		String url = "http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8";

		// For Testing
		// String url = new
		// File("C:\\Users\\Laura\\Desktop\\Arris\\ipad.m3u8").toURI().toURL().toString();

	}

	public static void ProcessURL(String url) {

		System.out.println("**********-Validation Process Start-**********");

		try {
			GetFileAndValidate(new URL(url), true);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("**********-Validation Process Complete-**********");
	}

	private static URL GetURL(URL url) {
		String newText = url.toString().replace("\\", "//").replaceAll("(?<!http:)\\/\\/", "/");
		try {
			return new URL(newText);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}

	private static void GetFileAndValidate(URL url, Boolean isMainFile) {
		HLSFileWDirectory hlsChidlFile;

		// Formats URL with proper slashes
		url = GetURL(url);

		try {
			if (FileExistsValidator.DoesFileExist(url.toString())) {

				hlsChidlFile = new HLSFileWDirectory(url, isMainFile);
				// THIS LINE IS ONLY IN PLACE FOR TESTING
				// No validate check on ts files was built
				if (!hlsChidlFile.FileExtension.equals("ts")) {
					ValidateFile(hlsChidlFile);
					ProcessChildFiles(hlsChidlFile);
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void ProcessChildFiles(HLSFileWDirectory hlsFile) {
		for (String file : hlsFile.MediaURIs) {

			try {
				if (hlsFile.Type.equals(HLSFileType.Type.URL))
					GetFileAndValidate(new URL(CommonFile.PathCombine(hlsFile.Directory.DirectoryPath, file)), false);
				else
					GetFileAndValidate(
							new File(CommonFile.PathCombine(hlsFile.Directory.DirectoryPath, file)).toURI().toURL(),
							false);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void ValidateFile(HLSFileWDirectory hlsFile) {
		Validator v = new Validator();
		v.File = hlsFile;
		v.ValidateFile();
	}

}

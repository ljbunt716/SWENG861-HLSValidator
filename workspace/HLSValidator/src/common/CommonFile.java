package common;

import java.io.File;

public class CommonFile {

	// Returns the extension of a file
	public static String GetFileExtension(String filePath) {

		int index = filePath.lastIndexOf('.');
		if (index > 0) {
			return filePath.substring(index + 1);
		}

		return "";
	}

	// Returns the file name portion of a file without the extension
	public static String GetFileBaseName(String filePath) {
		int index = filePath.lastIndexOf('.');

		if (index > 0) {
			return filePath.substring(0, index);
		}

		return "";

	}

	public static String GetFileDirectory(String filePath) {
		int index = filePath.lastIndexOf('/');

		if (index > 0) {
			return filePath.substring(0, index);
		}

		return "";
	}

	public static String PathCombine(String path1, String path2) {
		File file1 = null;
		File file2 = null;

		try {
			file1 = new File(path1);
		} catch (Exception e) {
			System.out.println("Error Getting File 1 in PathCombine");
		}
		try {
			file2 = new File(file1, path2);
		} catch (Exception e) {
			System.out.println("Error Getting File 2 in PathCombine");
		}

		if (!file1.equals(null) && !file2.equals(null))
			return file2.getPath();
		else
			return "";
	}

}

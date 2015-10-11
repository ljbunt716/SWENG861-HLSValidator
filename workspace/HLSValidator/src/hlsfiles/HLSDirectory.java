package hlsfiles;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HLSDirectory {
	public String DirectoryPath;
	public List<HLSFile> Files;

	public HLSDirectory() {
		Files = new ArrayList<HLSFile>();
	}

	public HLSDirectory(String directoryPath, HLSFileType.Type type) {
		this();
		DirectoryPath = GetFileDirectoryPath(directoryPath, type);

		File[] files = new File(DirectoryPath).listFiles();

		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					try {
						Files.add(new HLSFile(file.toURI().toURL()));
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// FileNames.add(file.getName());
				}
			}
		}
	}

	// Returns the Directory Path based on the URL provided in order to get
	// Files in Directory
	public static String GetFileDirectoryPath(String directoryPath, HLSFileType.Type type) {
		// If path is from file...
		if (type.equals(HLSFileType.Type.File))
			if (directoryPath.startsWith("file:/"))
				return directoryPath.substring(6);

		return directoryPath;
	}
}

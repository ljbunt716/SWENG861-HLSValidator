package hlsfiles;

import java.net.URL;

public class HLSFileType {
	public enum Type {
		File, URL
	}

	public static HLSFileType.Type GetFileType(URL url) {
		if (url.toString().startsWith("file:/"))
			return HLSFileType.Type.File;
		else
			return HLSFileType.Type.URL;
	}

	public static HLSFileType.Type GetFileType(String url) {
		if (url.startsWith("file:/"))
			return HLSFileType.Type.File;
		else
			return HLSFileType.Type.URL;
	}
}

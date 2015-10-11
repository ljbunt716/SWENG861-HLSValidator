package hlsfiles;

import java.net.URISyntaxException;
import java.net.URL;
import common.CommonFile;

public class HLSFileWDirectory extends HLSFile {
	public HLSDirectory Directory;

	public HLSFileWDirectory() {
		super();
	}

	public HLSFileWDirectory(URL url, Boolean isMainFile) throws URISyntaxException {
		super(url, isMainFile);
		Directory = new HLSDirectory(CommonFile.GetFileDirectory(url.toString()), super.Type);
	}
}

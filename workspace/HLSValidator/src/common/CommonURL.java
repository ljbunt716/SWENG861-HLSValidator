package common;

import java.net.URL;

public class CommonURL {
	
	// Returns the Full File Name
	public static String GetFileName(URL url) {
		String urlString = url.toString();
		int index = urlString.lastIndexOf('/');

		if (index > 0) {
			return urlString.substring(index + 1);
		}

		return "";

	}

}

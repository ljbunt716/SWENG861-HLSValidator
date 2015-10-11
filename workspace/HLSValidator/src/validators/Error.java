package validators;

public class Error {
	public String FailMessage;
	public String FailArea;
	public int LineNumber;

	public Error(String message, String area) {
		FailMessage = message;
		FailArea = area;
		LineNumber = 0;
	}

	public Error(String message, String area, int lineNumber) {
		FailMessage = message;
		FailArea = area;
		LineNumber = lineNumber;
	}
}

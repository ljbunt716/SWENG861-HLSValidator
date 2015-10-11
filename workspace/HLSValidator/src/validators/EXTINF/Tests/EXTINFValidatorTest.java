package validators.EXTINF.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import validators.EXTINF.EXTINFValidator;

public class EXTINFValidatorTest {

	@Test
	public void testDoesReturnIntGreaterThan0() {
		List<String> allLinesInFile = new ArrayList<String>();
		allLinesInFile.add("#EXTINF:6, no desc");

		assertTrue("your message", EXTINFValidator.GetEXTINFValue(allLinesInFile) > 0);
	}

	@Test
	public void testDoesReturnIntEqual0() {
		List<String> allLinesInFile = new ArrayList<String>();
		allLinesInFile.add("#TESTEXT:6, no desc");

		assertTrue("your message", EXTINFValidator.GetEXTINFValue(allLinesInFile) == 0);
	}

}

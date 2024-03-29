package validators.EXTXMEDIASEQUENCE.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import validators.EXTXMEDIASEQUENCE.EXTXMEDIASEQUENCEValueValidator;

public class EXTXMEDIASEQUENCEValueValidatorTest {

	@Test
	// Valid text passed in
	public void testDoesStringNotEmpty() {
		List<String> allLinesInFile = new ArrayList<String>();
		allLinesInFile.add("#EXT-X-MEDIA-SEQUENCE:6800");

		assertTrue(!EXTXMEDIASEQUENCEValueValidator.GetMediaSequenceValue(allLinesInFile).equals(""));
	}

	@Test
	// Invalid text passed in
	public void testDoesReturnIntEqual0() {
		List<String> allLinesInFile = new ArrayList<String>();
		allLinesInFile.add("#TESTEXT:6, no desc");

		assertTrue(EXTXMEDIASEQUENCEValueValidator.GetMediaSequenceValue(allLinesInFile).equals(""));
	}

}

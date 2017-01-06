package com.gauravbytes.good.srp.parser;

import java.io.File;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class FileParser {
	private Parser parser;

	public FileParser(Parser parser) {
		this.parser = parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public void parseFile(File file) {
		if (FileValidationUtils.isValidFile(file, parser.getFileType())) {
			parser.parse(file);
		}
	}
}

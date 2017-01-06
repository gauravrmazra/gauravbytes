package com.gauravbytes.good.srp.parser;

import java.io.File;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class JsonFileParser implements Parser {

	@Override
	public void parse(File file) {
		// Logic to parse json file
	}

	@Override
	public FileType getFileType() {
		return FileType.JSON;
	}

}

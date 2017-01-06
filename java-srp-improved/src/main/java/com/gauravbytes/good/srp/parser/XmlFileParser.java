package com.gauravbytes.good.srp.parser;

import java.io.File;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class XmlFileParser implements Parser {

	@Override
	public void parse(File file) {
		// logic to parse xml file
	}

	@Override
	public FileType getFileType() {
		return FileType.XML;
	}

}

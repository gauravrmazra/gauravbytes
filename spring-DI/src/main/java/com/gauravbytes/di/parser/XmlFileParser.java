package com.gauravbytes.di.parser;

import java.io.File;
import java.util.logging.Logger;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class XmlFileParser implements Parser {
	private static final Logger logger = Logger.getLogger(XmlFileParser.class.getName());

	@Override
	public void parse(File file) {
		// logic to parse xml file
		logger.info("Inside XMLFileParser");
	}

	@Override
	public FileType getFileType() {
		return FileType.XML;
	}

}

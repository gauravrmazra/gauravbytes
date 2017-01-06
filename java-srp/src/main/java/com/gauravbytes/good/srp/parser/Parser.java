package com.gauravbytes.good.srp.parser;

import java.io.File;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public interface Parser {
	// method to parse file
	public void parse(File file);

	// return filetype to validate
	public FileType getFileType();
}

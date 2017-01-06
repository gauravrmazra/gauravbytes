package com.gauravbytes.srp.parser;

import java.io.File;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class FileParser {

	public void parseFile(File file) {
		// parse file logic for xml, csv, json data in files
		if (isValidFile(file, FileType.CSV, FileType.XML, FileType.JSON)) {
			// parsing logic starts while if elseif elseif based on file type
		}
	}

	private boolean isValidFile(File file, FileType... types) {
		if (file == null || types == null || types.length == 0)
			return false;

		String fileName = file.getName().toLowerCase();
		for (FileType type : types) {
			if (fileName.endsWith(type.getExtension()))
				return true;
		}
		return false;
	}

}

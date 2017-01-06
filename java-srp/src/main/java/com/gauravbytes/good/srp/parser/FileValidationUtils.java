package com.gauravbytes.good.srp.parser;

import java.io.File;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class FileValidationUtils {

	private FileValidationUtils() {

	}

	public static boolean isValidFile(File file, FileType... types) {
		if (file == null || types == null || types.length == 0)
			return false;

		String fileName = file.getName().toLowerCase();
		for (FileType type : types) {
			if (fileName.endsWith(type.getExtension()))
				return true;
		}

		return false;
	}

	public static boolean isValidFile(File file, FileType type) {
		if (file == null || type == null)
			return false;

		String fileName = file.getName().toLowerCase();
		if (fileName.endsWith(type.getExtension()))
			return true;

		return false;
	}
}

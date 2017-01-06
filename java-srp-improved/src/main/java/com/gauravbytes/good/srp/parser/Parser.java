package com.gauravbytes.good.srp.parser;

import java.io.File;
import java.util.Objects;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public interface Parser {
	public void parse(File file);

	public FileType getFileType();

	public default boolean canParse(File file) {
		return Objects.nonNull(file) && file.getName().endsWith(getFileType().getExtension());
	}
}

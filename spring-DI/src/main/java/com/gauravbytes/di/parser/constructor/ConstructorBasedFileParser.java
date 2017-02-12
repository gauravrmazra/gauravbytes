package com.gauravbytes.di.parser.constructor;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gauravbytes.di.parser.Parser;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
@Component
public class ConstructorBasedFileParser {
	private Parser parser;

	@Autowired
	public ConstructorBasedFileParser(Parser parser) {
		this.parser = parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public void parseFile(File file) {
		if (parser.canParse(file)) {
			parser.parse(file);
		}
	}
}

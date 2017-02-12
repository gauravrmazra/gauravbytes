package com.gauravbytes.di.parser.setter;

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
public class SetterBasedFileParser {
	private Parser parser;

	public SetterBasedFileParser() {
	}

	@Autowired
	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public void parseFile(File file) {
		if (parser.canParse(file)) {
			parser.parse(file);
		}
	}
}

package com.gauravbytes.schemageneration;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.compiler.specific.SpecificCompiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class PragmaticSchemaGeneration {
	private static final Logger LOGGER = LoggerFactory.getLogger(PragmaticSchemaGeneration.class);

	public static void main(String[] args) {
		try {
			SpecificCompiler compiler = new SpecificCompiler(new Schema.Parser().parse(new File("src/main/avro/employee.avsc")));
			compiler.compileToDestination(new File("src/main/avro"), new File("src/main/java"));
		} catch (IOException e) {
			LOGGER.error("Exception occurred parsing schema: ", e);
		}
	}
}

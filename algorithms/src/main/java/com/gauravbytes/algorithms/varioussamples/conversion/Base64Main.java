package com.gauravbytes.algorithms.varioussamples.conversion;

import static java.util.Base64.getDecoder;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class Base64Main {
	public static void main(String[] args) {
		byte[] decoded = getDecoder().decode("WW91IGNhbiBzZWUgdGhlIE1hdHJpeCBhbmQgc29sdmUgUmVnRXgtQ3Jvc3N3b3JkcyB3aXRob3V0IGV2ZW4gYmxpbmtpbmcgb25jZQ==");
		System.out.println(new String(decoded));
	}
}

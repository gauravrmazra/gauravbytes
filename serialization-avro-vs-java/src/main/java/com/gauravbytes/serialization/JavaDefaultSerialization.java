package com.gauravbytes.serialization;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import com.gauravbytes.model.Employee2;
import com.gauravbytes.model.Sex;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class JavaDefaultSerialization {
	public static void main(String[] args) throws Exception {
		Employee2 employee = new Employee2("Gaurav", "Mazra", Sex.MALE);
		byte[] payload;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
				ObjectOutputStream  oos = new ObjectOutputStream(baos);) {
			oos.writeObject(employee);
			
			payload = baos.toByteArray();
		}
		catch (Exception e) {
			System.err.println(e);
			throw e;
		}
		System.out.println(new String(payload));
		System.out.println(payload.length);
		
	}
}

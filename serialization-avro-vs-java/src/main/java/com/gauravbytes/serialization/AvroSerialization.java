package com.gauravbytes.serialization;

import java.io.ByteArrayOutputStream;

import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;

import com.gauravbytes.avro.Employee;
import com.gauravbytes.avro.SEX;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class AvroSerialization {
	public static void main(String[] args) throws Exception {
		Employee employee = Employee.newBuilder().setFirstName("Gaurav")
				.setLastName("Mazra").setSex(SEX.MALE).build();
		
		byte[] payload;
		DatumWriter<Employee> datumWriter = new SpecificDatumWriter<>(Employee.class);
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			Encoder out = EncoderFactory.get().binaryEncoder(baos, null);
			datumWriter.write(employee, out );
			out.flush();
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

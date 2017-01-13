package com.gauravbytes.schemageneration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import com.gauravbytes.avro.Employee;
import com.gauravbytes.avro.SEX;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class AvroDatumExample {
	public void jsonReadWriteExample() throws IOException {
		Employee employee = Employee.newBuilder().setFirstName("Gaurav")
				.setLastName("Mazra").setSex(SEX.MALE).build();

		DatumWriter<Employee> employeeWriter = new SpecificDatumWriter<>(Employee.class);
		byte[] data;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			Encoder jsonEncoder = EncoderFactory.get().jsonEncoder(Employee.getClassSchema(), baos);
			employeeWriter.write(employee, jsonEncoder);
			jsonEncoder.flush();
			data = baos.toByteArray();
		}
		
		// serialized data
		System.out.println(new String(data));
		
		DatumReader<Employee> employeeReader = new SpecificDatumReader<>(Employee.class);
		Decoder decoder = DecoderFactory.get().jsonDecoder(Employee.getClassSchema(), new String(data));
		employee = employeeReader.read(null, decoder);
		//data after deserialization
		System.out.println(employee);
	}

	public void binaryReadWriteExample() throws IOException {
		Employee employee = Employee.newBuilder().setFirstName("Gaurav")
				.setLastName("Mazra").setSex(SEX.MALE).build();

		DatumWriter<Employee> employeeWriter = new SpecificDatumWriter<>(Employee.class);
		byte[] data;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			Encoder jsonEncoder = EncoderFactory.get().binaryEncoder(baos, null);
			employeeWriter.write(employee, jsonEncoder);
			jsonEncoder.flush();
			data = baos.toByteArray();
		}
		
		// serialized data
		System.out.println(data);
		
		DatumReader<Employee> employeeReader = new SpecificDatumReader<>(Employee.class);
		Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);
		employee = employeeReader.read(null, decoder);
		//data after deserialization
		System.out.println(employee);
	}

	public static void main(String[] args) throws IOException {
		AvroDatumExample avroDatumExample = new AvroDatumExample();
		avroDatumExample.jsonReadWriteExample();
		avroDatumExample.binaryReadWriteExample();
	}
}

package com.gauravbytes.serialization;

import java.io.ByteArrayOutputStream;

import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.reflect.ReflectDatumWriter;

import com.gauravbytes.avro.Node;


/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class AvroReflectDataSerializationTest {
	public static void main(String[] args) throws Exception {
		Node node = new Node();
		node.setValue("Gaurav");
		node.setNext(node);
		
		byte[] payload;
		DatumWriter<Node> datumWriter = new ReflectDatumWriter<>(Node.class);
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			Encoder out = EncoderFactory.get().binaryEncoder(baos, null);
			datumWriter.write(node, out );
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

package com.gauravbytes.serialization;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import com.gauravbytes.model.Node;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class JavaSerializationCircularRefTest {
	
	public static void main(String[] args) throws Exception {
		Node node = new Node("Gaurav");
		node.setNode(node);
		
		byte[] payload;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
				ObjectOutputStream  oos = new ObjectOutputStream(baos);) {
			oos.writeObject(node);
			
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

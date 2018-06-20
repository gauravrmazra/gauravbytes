package com.gauravbytes.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Gaurav Rai Mazra <a href="http://www.gauravbytes.com">Catch me</a>
 *
 */
public class SimpleSerializationExample {
	public static void main(String[] args) {
		Dog dog = new Dog(50, "Titan"); // create dog object with height 50 and name Titan
		System.out.println("Before Serialization");
		System.out.println(dog);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dog.ser"))) {
			oos.writeObject(dog);// serialize the dog object
		} catch (IOException ioEx) {
			/* Don't Swallow exception in real projects */ }

		dog = null; // let clear old dog object reference
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dog.ser"))) {
			dog = (Dog) ois.readObject();// deserialize dog object
		} catch (IOException | ClassCastException | ClassNotFoundException ex) {
			/* Don't Swallow exception in real projects */ }

		System.out.println("After Serialization");
		System.out.println(dog);
	}
}

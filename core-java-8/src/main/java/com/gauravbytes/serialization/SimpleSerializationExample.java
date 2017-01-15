package com.gauravbytes.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 *
 */
public class SimpleSerializationExample {
	public static void main(String[] args) {
		Dog dog = new Dog(50, "Titan"); // create dog object with height 50 and name Titan 
	  System.out.println("Before Serialization");
	  System.out.println(dog.toString());
	  try {
	   FileOutputStream fos = new FileOutputStream("dog.ser");
	   ObjectOutputStream oos = new ObjectOutputStream(fos);
	   oos.writeObject(dog);// serialize the dog object
	   oos.close();
	  }
	  catch (IOException ioEx) { /* Don't Swallow exception in real projects */ }
	  
	  try {
	   dog = null; // let clear old dog object reference
	   FileInputStream fis = new FileInputStream("dog.ser");
	   ObjectInputStream ois = new ObjectInputStream(fis);
	   dog = (Dog) ois.readObject();// deserialize dog object
	   ois.close();
	   System.out.println("After Serialization");
	   System.out.println(dog.toString());
	  }
	  catch (IOException | ClassCastException | ClassNotFoundException ex) { /* Don't Swallow exception in real projects */ }
	}
}

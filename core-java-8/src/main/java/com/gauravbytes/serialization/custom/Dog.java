package com.gauravbytes.serialization.custom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author Gaurav Rai Mazra <a href="http://www.gauravbytes.com">Catch me</a>
 *
 */
public class Dog implements Serializable {

	private static final long serialVersionUID = 6870143058315212650L;

	private int height;
	private String name;
	private transient Collar myCollar;

	public Dog(int height, String name, Collar myCollar) {
		super();
		this.height = height;
		this.name = name;
		this.setMyCollar(myCollar);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collar getMyCollar() {
		return myCollar;
	}

	public void setMyCollar(Collar myCollar) {
		this.myCollar = myCollar;
	}

	private void writeObject(ObjectOutputStream os) throws IOException {
		try {
			os.defaultWriteObject();// lets first have default serialization happens
			os.writeInt(myCollar.getSize()); // save custom values
		} catch (IOException ex) {
		}
	}

	private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
		try {
			is.defaultReadObject();// lets first have default deserialization happens
			myCollar = new Collar(is.readInt()); // custom read values
		} catch (IOException ex) {
		} catch (ClassNotFoundException cnf) {
		}
	}

	@Override
	public String toString() {
		return "Dog [height=" + height + ", name=" + name + ", myCollar=" + myCollar + "]";
	}
}

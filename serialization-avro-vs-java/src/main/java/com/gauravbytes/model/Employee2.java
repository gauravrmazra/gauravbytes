package com.gauravbytes.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class Employee2 implements Externalizable {
	private String firstName;
	private String lastName;
	private Sex sex;
	
	public Employee2() {
		
	}

	public Employee2(String firstName, String lastName, Sex sex) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee2 other = (Employee2) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex + "]";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(firstName);
		out.writeObject(lastName);
		out.writeObject(sex);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		firstName = (String) in.readObject();
		lastName = (String) in.readObject();
		sex = (Sex) in.readObject();
	}
}

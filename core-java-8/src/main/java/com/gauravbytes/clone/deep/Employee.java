package com.gauravbytes.clone.deep;

/**
 * 
 * @author Mazra, Gaurav Rai
 * {@link http://blog.gauravbytes.com}
 * 
 */
public class Employee implements Cloneable {
	private long id;
	private String name;
	private Address address;
	
	public Employee() {
		
	}
	
	public Employee(long id, String name, Address address) {
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	@Override
	public Employee clone() throws CloneNotSupportedException {
		Employee cloned = (Employee) super.clone();
		
		if (this.address == null) {
			cloned.setAddress(null);
		}
		else {
			cloned.setAddress(this.address.clone());
		}
		
		return cloned;
	}
	
}

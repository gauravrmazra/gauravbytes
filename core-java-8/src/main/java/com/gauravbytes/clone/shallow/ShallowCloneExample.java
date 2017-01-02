package com.gauravbytes.clone.shallow;


/**
 * 
 * @author Mazra, Gaurav Rai 
 * {@link http://blog.gauravbytes.com}
 *
 */
public class ShallowCloneExample {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee employee = new Employee(1, "Gaurav", new Address("Sector 37C", "Chandigarh", "India"));
		Employee shallowClone = (Employee) employee.clone();
		employee.getAddress().setCity("Hoshiarpur");
		// should return false
		System.out.println(employee.getAddress());
		System.out.println(shallowClone.getAddress());
		System.out.println(employee.getAddress().equals(shallowClone.getAddress()));
	}
}

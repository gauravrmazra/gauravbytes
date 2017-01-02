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
		System.out.println(employee == shallowClone);
	}
}

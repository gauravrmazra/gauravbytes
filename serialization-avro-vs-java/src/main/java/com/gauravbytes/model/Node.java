package com.gauravbytes.model;

import java.io.Serializable;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class Node implements Serializable {
	private static final long serialVersionUID = -4544953880547632256L;

	private String value;
	private Node next;
	
	public Node (String value) {
		this.value = value;
	}
	
	public void setNode(Node next) {
		this.next = next;
	}
	
	public Node getNode() {
		return this.next;
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	
}

package com.pojo;

public class Employee {

	private String id;
	
	private String name;
	
	private Address address;
	
	private Salary salary;

	public Employee(String id, String name, Address address, Salary salary) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	
}

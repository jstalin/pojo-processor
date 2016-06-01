package com.pojo;

public class Salary {
	
	private Float salary;

	private Bank bank;

	public Salary(Float salary, Bank bank) {
		this.salary = salary;
		this.bank = bank;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
}

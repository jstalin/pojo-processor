package com.pojo;

public class Bank {
	
	private Long accountNumber;
	
	private String name;
	
	private Loan loan;

	public Bank(Long accountNumber, String name, Loan loan) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.loan = loan;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}

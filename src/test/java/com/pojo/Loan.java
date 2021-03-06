package com.pojo;

public class Loan {
	
	private Integer id;
	
	private Float amount;

	public Loan(Integer id, Float amount) {
		this.id = id;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

}

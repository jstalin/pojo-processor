package com.pojo;

public class Main {

	public static void main(String[] args) throws Exception {
		Employee employee = new Employee("E11", "Stalin", new Address("Amman Street", "Bangalore", "Karnataka", "India"), new Salary(50000.0f, new Bank(12345l, "stalin", new Loan(8899, 200000f))));
		
		PojoProcessor processor = new PojoProcessor(employee);
		
		Loan loan = processor.get("/salary/bank/loan");
		System.out.println(loan.getAmount());
		
		String bankName = processor.get("/salary/bank/name");
		System.out.println(bankName);
		
		String street = processor.get("/address/street");
		System.out.println(street);
		
		Address address = processor.get("/address");
		System.out.println(address.getCountry());
		
		
		processor.set("/salary/bank/loan/amount", 45000f);
		
		processor.set("/salary/bank/loan/amount", 3000f);
		
		
		System.out.println(employee.getSalary().getBank().getLoan().getAmount());
		
	}

}

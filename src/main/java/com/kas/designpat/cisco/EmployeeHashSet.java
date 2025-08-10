package com.kas.designpat.cisco;

import java.util.*;


class InvalidInputException extends Exception {
	public InvalidInputException(String s) {
		super(s);
	}
}

class Employee {

	private int id = 0;
	private String name = null;
	private boolean male = true;

	Employee(int id, String name, boolean male) {
		super();
		this.id = id;
		this.name = name;
		this.male = male;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ",  male=" + male + "]";
	}

	/*@Override
	public int hashCode() {
		// Complete all relevent code
		return this.id;
	}*/

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Employee empl = (Employee) o;
		return empl.id == (this.id);
	}
	//if comment equals then same id entry can added in hashset
	////if comment hashcode then same id entry can added in hashset
	//need both method ow duplicacy will be there

}

public class EmployeeHashSet {

	/*
	 * Validate the input and create Employee object If any of the given input
	 * is not valid throw InvalidInputException();
	 */
	public static Employee createEmployee(String record) {

		// Complete the code
		String[] emprec = record.split(",");
		return new Employee(Integer.parseInt(emprec[0]), emprec[1], Boolean.parseBoolean(emprec[2]));

	}

	public static void main(String[] str) {

		// Input is expected as comma separated values for Employee object like
		// id(int), name (String),isMale(boolean)"
		// 1,John,true
		Scanner scan = new Scanner(System.in);

		HashSet<Employee> employeeSet = new HashSet<>();

		/*
		 * Process each line and create Employee object using the
		 * "createEmployee" method add in employeeSet
		 */
		while (true) {
			try {
				// Complete the code
				String inp = scan.nextLine();
				if (!inp.isEmpty()) {
					if (inp.split(",").length == 3) {
						Employee e = createEmployee(inp);
						employeeSet.add(e);
					} else
						throw new InvalidInputException("need 3 input");
				} else
					break;
			} catch (InvalidInputException e) {
				System.out.println(e + e.getMessage());
				System.exit(0);
			}

		}

		// Don't delete or modify this print statement
		System.out.println("Employees info : " + employeeSet);
		employeeSet.forEach(System.out::println);

	}

}
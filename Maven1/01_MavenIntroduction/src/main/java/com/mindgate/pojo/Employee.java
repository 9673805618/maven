package com.mindgate.pojo;

public class Employee {

	private int Employee_Id;
	private String name;
	private double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int employee_Id, String name, double salary) {
		super();
		Employee_Id = employee_Id;
		this.name = name;
		this.salary = salary;
	}

	public int getEmployee_Id() {
		return Employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [Employee_Id=" + Employee_Id + ", name=" + name + ", salary=" + salary + "]";
	}

}

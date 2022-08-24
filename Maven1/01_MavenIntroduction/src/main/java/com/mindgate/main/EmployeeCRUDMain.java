package com.mindgate.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

public class EmployeeCRUDMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int employeeId;
		String name;
		double salary;
		int choice;
		boolean result;
		String continuechoice;
		List<Employee> employelist;
		do {
			EmployeeServiceInterface employeeServiceInterface=new EmployeeService();
			System.out.println("1 for Add a new Employee");
			System.out.println("2 for update Employee");
			System.out.println("3 for Delete Employee");
			System.out.println("4 for Select one employee");
			System.out.println("5 for select all employee");
			System.out.println("Enter your choice");
			choice=scanner.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("enter employee Id");
			employeeId=scanner.nextInt();
			scanner.nextLine();
			System.out.println("enter employee name");
			name=scanner.nextLine();
			
			System.out.println("enter employee salary");
			salary=scanner.nextDouble();
			Employee employee=new Employee(employeeId, name, salary);
			result=employeeServiceInterface.addNewEmployee(employee);
			if(result) {
				System.out.println("insert successfully..!");
			}
			else {
				System.out.println("insert failed");
			}
			break;
		}
		case 2:{
			System.out.println("enter employeeId");
			int id=scanner.nextInt();
			
			
		}
		case 5:{
			employelist= employeeServiceInterface.getAllEmployee();
			for (Employee e : employelist) {
				System.out.println(e);
			}
			break;
			
		}
		case 3:{
			System.out.println("enter employeeId to delete record");
			employeeId=scanner.nextInt();
			result=employeeServiceInterface.deleteEmployeeById(employeeId);
			if(result) {
				System.out.println("Delete Successfully..!");
			}
			else {
				System.out.println("delete failed");
			}
			break;
		}
		default:
			System.out.println("Invalid choice");
		
		}
		System.out.println("Do you want to continue yes|No");
		continuechoice=scanner.next();
		}
		while(continuechoice.equalsIgnoreCase("yes"));
	}
}

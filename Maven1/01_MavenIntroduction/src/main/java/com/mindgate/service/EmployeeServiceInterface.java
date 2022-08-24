package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.Employee;

public interface EmployeeServiceInterface {

	boolean addNewEmployee(Employee employee);
	List<Employee> getAllEmployee();
	boolean deleteEmployeeById(int employee_Id);
	Employee getEmployeeByEmployeeId(int employeeId);
	boolean updateEmployee(Employee employee);
}

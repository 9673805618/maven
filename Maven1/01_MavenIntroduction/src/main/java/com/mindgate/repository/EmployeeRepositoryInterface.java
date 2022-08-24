package com.mindgate.repository;

import java.util.List;

import com.mindgate.pojo.Employee;

public interface EmployeeRepositoryInterface  {

	boolean addNewEmployee(Employee employee);
	List<Employee> getAllEmployee();
	boolean deleteEmployeeById(int employee_Id);
	Employee getEmployeeByEmployeeId(int employeeId);
	boolean updateEmployee(Employee employee);
}

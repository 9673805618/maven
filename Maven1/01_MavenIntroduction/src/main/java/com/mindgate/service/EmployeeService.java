package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.Employee;
import com.mindgate.repository.EmployeeRepository;
import com.mindgate.repository.EmployeeRepositoryInterface;

public class EmployeeService implements EmployeeServiceInterface {

	private EmployeeRepositoryInterface employeeRepositoryInterface = new EmployeeRepository();

	@Override
	public boolean addNewEmployee(Employee employee) {
		System.out.println("in service..");
		return employeeRepositoryInterface.addNewEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepositoryInterface.getAllEmployee();
	}

	@Override
	public boolean deleteEmployeeById(int employee_Id) {
		
		return employeeRepositoryInterface.deleteEmployeeById(employee_Id);
	}

	

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		
		return employeeRepositoryInterface.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		return employeeRepositoryInterface.updateEmployee(employee);
	}
	
	
	

}

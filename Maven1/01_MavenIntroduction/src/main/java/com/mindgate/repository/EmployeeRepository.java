package com.mindgate.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindgate.pojo.Employee;

public class EmployeeRepository implements EmployeeRepositoryInterface {

	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "system";
	private String password = "mindgate123";
	private ResultSet resultSet;

	private List<Employee> employeeList;
	private Connection connection;
	private PreparedStatement preparedStatement;

	private static final String Insert_Employee="insert into Employee_Info values (?,?,?)";
	private static final String SelectAllEmployee="select * from Employee_Info";
	private static final String DeleteEmployee="delete from Employee_Info where employee_Id=?";
	private static final String Select_One_Employee="select * from Employee_Info where employee_Id=?";
	private static final String Update_Employee="update Employee_Info set name=? ,salary=? where employee_Id=?";

	@Override
	public boolean addNewEmployee(Employee employee) {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement=connection.prepareStatement(Insert_Employee);
			preparedStatement.setInt(1, employee.getEmployee_Id());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.setString(2, employee.getName());
			
			int insertcount=preparedStatement.executeUpdate();
			
			if(insertcount>0) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement=connection.prepareStatement(SelectAllEmployee);
			resultSet=preparedStatement.executeQuery();
			employeeList=new ArrayList<>();
			while(resultSet.next()) {
				int employeeId=resultSet.getInt("employee_Id");
				String name=resultSet.getString("name");
				double salary=resultSet.getDouble("salary");
				
				Employee employee=new Employee(employeeId, name, salary);
				employeeList.add(employee);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}
	@Override
	public boolean deleteEmployeeById(int employee_Id) {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement=connection.prepareStatement(DeleteEmployee);
			preparedStatement.setInt(1, employee_Id);
			
			int insertcount=preparedStatement.executeUpdate();
			
			if(insertcount>0) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement=connection.prepareStatement(Select_One_Employee);
			preparedStatement.setInt(1, employeeId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				int empId=resultSet.getInt("employee_Id");
				String name=resultSet.getString("name");
				double salary=resultSet.getDouble("salary");
				
				Employee employee=new Employee(empId, name, salary);
				return employee;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement=connection.prepareStatement(Update_Employee);
			preparedStatement.setInt(3, employee.getEmployee_Id());
			preparedStatement.setDouble(2, employee.getSalary());
			preparedStatement.setString(1, employee.getName());
			
			int insertcount=preparedStatement.executeUpdate();
			
			if(insertcount>0) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

}

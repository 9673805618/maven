<%@page import="com.mindgate.pojo.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h2>Update Employee</h2>
    <% Employee employee= (Employee)session.getAttribute("emp"); %>
    
    <form action="UpdateEmployeeServlet" method="post">
        <label>Employee Id :</label>
        <input type="text" name="employeeId" value="<%= employee.getEmployee_Id()  %>" readonly="readonly" >
        <br><br>
        <label>Name :</label>
        <input  type="text" name="name" value="<%= employee.getName()  %>">
        <br><br>
        <label>Salary :</label>
        <input type="number" name="salary" value="<%= employee.getSalary()  %>" >
        <br><br>
        <input type="submit" value="Update Employee">
   </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
   <h2>New Employee</h2>
   <form action="AddNewEmployeeServlet" method="post">
        <label>Employee Id :</label>
        <input type="text" name="employeeId" >
        <br><br>
        <label>Name :</label>
        <input  type="text" name="name">
        <br><br>
        <label>Salary :</label>
        <input type="number" name="salary" >
        <br><br>
        <input type="submit" value="Add">
        
        <br><br>
        <a href="index.jsp">All Employee</a>
   </form>
</body>
</html>
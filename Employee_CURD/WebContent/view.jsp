<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.sumanta.Dao.EmployeeDao,com.sumanta.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Users List</h1>  
  
<%  
List<Employee> list=EmployeeDao.getAllRecords();  
request.setAttribute("list",list);  
%>  
  
<table border="1" width="90%">  
<tr><th>FName</th><th>LName</th><th>Email</th><th>Password</th>  
<th>Address</th><th>Zip</th><th>Country</th><th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${u.getFname()}</td><td>${u.getLname()}</td><td>${u.getEmail()}</td>  
<td>${u.getPass()}</td><td>${u.getAddress()}</td><td>${u.getZip()}</td> <td>${u.getCountry()}</td> 
<td><a href="editform.jsp?id=${u.getEmail()}">Edit</a></td>  
<td><a href="deleteuser.jsp?email=${u.getEmail()}">Delete</a></td></tr>  
</c:forEach>  
</table>  
<br/><a href="AddEmployee.jsp">Add New User</a>  
  

</body>
</html>
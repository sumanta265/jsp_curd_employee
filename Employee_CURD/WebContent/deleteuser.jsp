<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <%@page import="com.sumanta.Dao.EmployeeDao"%> 
<jsp:useBean id="q" class="com.sumanta.Employee"></jsp:useBean> 
<jsp:setProperty property="*" name="q"/>
<title>Insert title here</title>
</head>
<body>
<%

EmployeeDao.del(q);
response.sendRedirect("view.jsp");  

%>
</body>
</html>
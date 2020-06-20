<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.sumanta.Dao.EmployeeDao" %>
  <jsp:useBean id="o" class="com.sumanta.Employee"></jsp:useBean>
  <jsp:setProperty property="*" name="o"/>
<%

int i=EmployeeDao.save(o);

if(i>0){
	
	
	response.sendRedirect("success.jsp");
	
	
	
	
}

else{
	
	response.sendRedirect("error.jsp");
	
}

 %>
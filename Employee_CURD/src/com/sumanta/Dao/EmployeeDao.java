package com.sumanta.Dao;
import java.sql.*;
import java.util.ArrayList;

import com.sumanta.Employee;

import java.util.*;

public class EmployeeDao {

	public static Connection getConnection() {
		
		Connection con=null;
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=DriverManager.getConnection("jdbc:mysql://localhost:3308/sumanta","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
		
	}
	
	
	
	public static int save(Employee e)
	{
		int status=0;
		
		
		Connection con=getConnection();
		String str="insert into Employee(fname,lname,email,pass,address,zip,country)values(?,?,?,?,?,?,?)";
				
		try {
			PreparedStatement ps=con.prepareStatement(str);
			
			ps.setString(1,e.getFname());
			ps.setString(2,e.getLname());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getPass() );
			ps.setString(5, e.getAddress());
			ps.setString(6,e.getZip());
			ps.setString(7,e.getCountry());
			
			status=ps.executeUpdate();
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return status;
		
	}
	
	public static List<Employee> getAllRecords(){  
	    List<Employee> list=new ArrayList<Employee>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from employee");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Employee u=new Employee();  
	            u.setFname(rs.getString("fname"));  
	            u.setLname(rs.getString("lname"));  
	            u.setEmail(rs.getString("email"));  
	            u.setPass(rs.getString("pass"));  
	            u.setAddress(rs.getString("address"));  
	            u.setZip(rs.getString("zip"));  
	            u.setCountry(rs.getString("country")); 
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	public static void del(Employee u){  
	    int status=0; 
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from Employee where email=?");  
	        ps.setString(1,u.getEmail());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	      
	}  
	
}

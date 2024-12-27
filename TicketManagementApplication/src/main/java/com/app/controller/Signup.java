package com.app.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/Project2?serverTimezone=UTC";
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection(url,"root","");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");
	    String password=request.getParameter("password");
	    String contact=request.getParameter("contact");
	    String url="jdbc:mysql://localhost:3306/Project2?serverTimezone=UTC";
	    Connection con=null;
	    PreparedStatement ps=null;
	   if(regData(name,email,password,contact)) {
		   response.getWriter().println("successfull");
		   response.sendRedirect("Signin.jsp");
	   }
	   else {
		   response.getWriter().println("Error");
	   }
	}

	public boolean regData(String name,String email,String password,String contact) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=getConnection();
			ps=con.prepareStatement("insert into regDetails(username,email,password,contact) values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, contact);
			int n=ps.executeUpdate();
			
			if(n>0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

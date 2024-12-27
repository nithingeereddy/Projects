package com.katpro.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.*;
import com.katpro.model.*;
import java.util.*;

@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String password=request.getParameter("pass");
			String contact=request.getParameter("contact");
			RequestDispatcher rd=null;
			List<userReg> ur=new ArrayList<>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Demo","root","root");
			PreparedStatement ps=con.prepareStatement("insert into users (name,email,password,contact) values (?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, contact);
			ur.add(new userReg(name,email,password,contact));
			int n=ps.executeUpdate();
			if(n>0) {
				request.setAttribute("status","success");
				rd=request.getRequestDispatcher("login.jsp");
			}
			else {
				request.setAttribute("status", "Failed");
				rd=request.getRequestDispatcher("registration.jsp");
			}
			rd.forward(request, response);
		}
		catch(Exception e) {
			response.getWriter().println("There is an exception in Registration Servlet "+e);
		}
	}

}

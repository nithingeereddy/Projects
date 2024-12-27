package com.katpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;
import com.katpro.model.userReg;
import javax.servlet.annotation.*;
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String email=request.getParameter("username");
			String password=request.getParameter("password");
			RequestDispatcher rd=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			HttpSession session=request.getSession();
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Demo","root","root");
			PreparedStatement ps=con.prepareStatement("select *from users where email=? and password=?");
			System.out.println("Hey I am here " +email+" "+password);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				session.setAttribute("name",rs.getString("name"));
				rd=request.getRequestDispatcher("index.jsp");
				System.out.println("Hey I am in if");
			}
			else {
				session.setAttribute("name",null);
				rd=request.getRequestDispatcher("login.jsp");
				System.out.println("Hey I am in else");
			}
			rd.forward(request, response);
		}
		catch(Exception e) {
			response.getWriter().println("There is an exception in Login Servlet "+e);
		}
	}

}

package com.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.*;


@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String name="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String email=request.getParameter("email");
		    String password=request.getParameter("password");
		    HttpSession session=request.getSession();
		    RequestDispatcher pd=null;
		   if(userValidate(email,password)) {
			   session.setAttribute("name", name);
			  pd=request.getRequestDispatcher("Home.jsp");
		   }
		   else {
			   response.getWriter().println("Failure");
		   }
		   pd.forward(request, response);
		}

		public boolean userValidate(String email,String password) {
			Connection con=null;
			PreparedStatement ps=null;
			try {
				con=getConnection();
				ps=con.prepareStatement("select *from regDetails where email=? and password=?");
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					name=rs.getString("username");
					return true;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	  
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
}

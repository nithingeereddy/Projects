package net.app.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail=request.getParameter("username");
		String upwd=request.getParameter("password");
		RequestDispatcher rd=null;
		HttpSession session=request.getSession();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pro?serverTimezone=UTC", "root", "");
			PreparedStatement ps=con.prepareStatement("select *from user where uemail=? and upwd=?");
		    ps.setString(1, uemail);
		    ps.setString(2, upwd);
		    ResultSet rs=ps.executeQuery();
		    response.getWriter().println("Running");
		    if(rs.next()) {
		    	System.out.println("In If");
		    response.getWriter().println("Heyy Logged in");
		    session.setAttribute("name", rs.getString("uname"));
		    rd=request.getRequestDispatcher("user-form.jsp");
		    }
		    else{
		    	System.out.println("In else");
		    	 session.setAttribute("name", rs.getString("uname"));
		    	 rd=request.getRequestDispatcher("login.jsp");
		    	response.getWriter().println("Not Logged in");
		    }
		    rd.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

package net.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String uemail=request.getParameter("email");
		String upwd=request.getParameter("password");
		String ucontact=request.getParameter("contact");
		System.out.println("Hey I am in registration servlet");
		RequestDispatcher rd=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Pro?serverTimezone=UTC","root","");
			PreparedStatement ps=con.prepareStatement("insert into user(uname,uemail,upwd,ucontact) values (?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, uemail);
			ps.setString(3, upwd);
			ps.setString(4, ucontact);
			int result=ps.executeUpdate();
			
			if(result>0) {
				request.setAttribute("status", "success");
				rd=request.getRequestDispatcher("Login.jsp");
			}
			else {
				request.setAttribute("status", "failed");
				rd=request.getRequestDispatcher("Register.jsp");
			}
			rd.forward(request,response);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}

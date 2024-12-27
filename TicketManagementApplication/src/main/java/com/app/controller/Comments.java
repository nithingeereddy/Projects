package com.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

/**
 * Servlet implementation class Comments
 */
@WebServlet("/Comments")
public class Comments extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int tid=Integer.parseInt(request.getParameter("ticketNo"));	
	String comment=request.getParameter("name");
	PreparedStatement ps=null;
	RequestDispatcher rd=null;
	try {
		Connection con=getConnection();
		 ps=con.prepareStatement("insert into comments(tid,comments) values(?,?)");
		ps.setInt(1,tid);
		ps.setString(2,comment);
		int n=ps.executeUpdate();
		if(n>0) {
			request.setAttribute("status", true);
			rd=request.getRequestDispatcher("Comments.jsp");
		}
		else {
			request.setAttribute("status", false);
		}
		rd.forward(request, response);;
	}
	catch(Exception e) {
		
	}
			}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/Project2?serverTimezone=UTC";
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, "root", "");
        return con;
    }
}

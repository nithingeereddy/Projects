package com.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteTicket")
public class deleteTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/Project2?serverTimezone=UTC";
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, "root", "");
        return con;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tid=Integer.parseInt(request.getParameter("ticketNo"));
		System.out.println("Heyy I am here1 "+tid);
		 Connection con=null;
	        PreparedStatement ps=null;
	        ResultSet rs=null;
	        RequestDispatcher rd=null;
	        try {
	        	con=getConnection();

	        	ps=con.prepareStatement("update comments set tid=null where tid=?");
	        	ps.setInt(1,tid);
	        	ps.executeUpdate();
	        	ps=con.prepareStatement("delete from ticketDetails where tid=?");
	        	ps.setInt(1,tid);
	        	ps.executeUpdate();
	        		System.out.println("Hey i am in delete");
	        		response.sendRedirect("Status");
	        		
	        	
	        }
	        catch(Exception e) {
	        	
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

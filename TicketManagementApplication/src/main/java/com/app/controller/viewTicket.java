package com.app.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.app.model.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

@WebServlet("/Status")
public class viewTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("Hey I am here in status servlet");
        List<TicketData> ticketList = fetchDataFromDatabase(); 
        request.setAttribute("ticketList", ticketList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Status.jsp");
        System.out.println("Hey I am here in status servlet1");
        dispatcher.forward(request, response);
    }
    private List<TicketData> fetchDataFromDatabase() {
        List<TicketData> ticketList = new ArrayList<>();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
        	con=getConnection();
        	ps=con.prepareStatement("select *from ticketDetails");
        	rs=ps.executeQuery();
        	while(rs.next()) {
        		int ticketId=rs.getInt("tid");
        		 String type = rs.getString("type");
                 String  priority = rs.getString("priority");
                 String issueDetails = rs.getString("issueDetails");
                 String employeeName = rs.getString("employeeName");
                 TicketData ticket=new TicketData(ticketId,type,priority,issueDetails,employeeName);
                 ticketList.add(ticket);
        	}
        	
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
        }
        
        return ticketList;
    }
   
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/Project2?serverTimezone=UTC";
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, "root", "");
        return con;
    }
}


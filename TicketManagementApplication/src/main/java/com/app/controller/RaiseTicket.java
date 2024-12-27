package com.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.*;

@WebServlet("/raiseTicket")
public class RaiseTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
    List<TicketData> ticketList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 try {
    	int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        String type = request.getParameter("ticketType");
        String priority = request.getParameter("priority");
        String issueDetails = request.getParameter("issueDetails");
        String employeeName = request.getParameter("employeeName");
        TicketData ticket = new TicketData(ticketId,type,priority, issueDetails,employeeName);
        ticketList.add(ticket);
        request.setAttribute("ticketList", ticketList);
System.out.println("Hey i am here in raise");
        Connection con = null;
        PreparedStatement ps = null;
       
            con = getConnection();
            ps = con.prepareStatement("insert into ticketDetails(tid,type,priority,issuedetails,employeeName) values(?,?,?,?,?)");
            ps.setInt(1, ticketId);
            ps.setString(2, type);
            ps.setString(3, priority);
            ps.setString(4, issueDetails);
            ps.setString(5, employeeName);
            int n = ps.executeUpdate();
            if (n > 0) {
                System.out.println("Ticket Data insertion successfull");
                response.sendRedirect("Status");
            } else {
                System.out.println("insertion Failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	 finally {
    		 System.out.println(ticketList.size());
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

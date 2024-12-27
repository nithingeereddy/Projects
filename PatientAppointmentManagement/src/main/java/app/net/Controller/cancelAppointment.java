package app.net.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import app.net.Model.*;

@WebServlet("/cancelPatient")
public class cancelAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/PatientDB?serverTimezone=UTC";
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, "root", "");
        return con;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pNo=Integer.parseInt(request.getParameter("patientNo"));
		 Connection con=null;
	        PreparedStatement ps=null;
	        ResultSet rs=null;
	        RequestDispatcher rd=null;
	        try {
	        	con=getConnection();
	        	 ps = con.prepareStatement("UPDATE reviews SET pNo = NULL WHERE pNo = ?");
	             ps.setInt(1, pNo);
	             ps.executeUpdate();
	        	ps=con.prepareStatement("delete from patientDetails where pNo=?");
	        	ps.setInt(1,pNo);
	        	ps.executeUpdate();
	    
	        		response.sendRedirect("Bookings");
	        		
	        	
	        }
	        catch(Exception e) {
	        	
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package app.net.Controller;

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
import app.net.Model.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

@WebServlet("/Bookings")
public class Bookings extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        List<Patient> patientList = fetchData(); 
        request.setAttribute("patientList", patientList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Bookings.jsp");
        dispatcher.forward(request, response);
    }
    private List<Patient> fetchData() {
        List<Patient> patientList = new ArrayList<>();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
        	con=getConnection();
        	ps=con.prepareStatement("select *from patientDetails");
        	rs=ps.executeQuery();
        	while(rs.next()) {
        		 int patientNo = rs.getInt("pNo");
        	        String patientName = rs.getString("name");
        	        String location = rs.getString("location");
        	        String issue = rs.getString("issue");
        	        String contact = rs.getString("contact");
        	       
        	        Patient patient = new Patient(patientNo, patientName, location, issue, contact);
        	        patientList.add(patient);
        	}
        	
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
        }
        
        return patientList;
    }
   
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/PatientDB?serverTimezone=UTC";
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, "root", "");
        return con;
    }
}

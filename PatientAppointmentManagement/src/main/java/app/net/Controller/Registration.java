package app.net.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/Signup")

	
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username=request.getParameter("name");
	    String email=request.getParameter("email");
	    String password=request.getParameter("password");
	    String contact=request.getParameter("contact");
	    String url="jdbc:mysql://localhost:3306/PatientDB?serverTimezone=UTC";
	    Connection con=null;
	    PreparedStatement ps=null;
	   if(userDetails(username,email,password,contact)) {
		   response.getWriter().println("Data inserted successfully");
	   }
	   else {
		   response.getWriter().println("Data inserted Error!!!");
	   }
	}
	public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/PatientDB?serverTimezone=UTC";
		Connection connection=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    connection=DriverManager.getConnection(url,"root","");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public boolean userDetails(String username,String email,String password,String contact) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=getConnection();
			ps=con.prepareStatement("insert into userData(username,email,password,contact) values(?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, contact);
			int n=ps.executeUpdate();
			
			if(n>0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

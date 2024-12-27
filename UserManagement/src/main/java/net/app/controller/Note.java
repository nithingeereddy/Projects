package net.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Note
 */
@WebServlet("/Note")
public class Note extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));	
		String note=request.getParameter("note");
		System.out.println(id+" "+note);
		PreparedStatement ps=null;
		RequestDispatcher rd=null;
		try {
			Connection con=getConnection();
			 ps=con.prepareStatement("insert into Notes(id,note) values(?,?)");
			ps.setInt(1,id);
			ps.setString(2,note);
			int n=ps.executeUpdate();
			if(n>0) {
				request.setAttribute("status", true);
				rd=request.getRequestDispatcher("Note.jsp");
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
        String url = "jdbc:mysql://localhost:3306/Pro?serverTimezone=UTC";
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, "root", "");
        return con;
    }

}

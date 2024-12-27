package app.net.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Review")
public class Review extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int patientNo = Integer.parseInt(request.getParameter("patientNo"));
        String review = request.getParameter("review");
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            ps = con.prepareStatement("insert into reviews(review,pNo) values(?,?)");
            ps.setInt(2, patientNo);
            ps.setString(1, review);
            int n = ps.executeUpdate();
            if (n > 0) {
                request.setAttribute("message", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            // Redirect to the same JSP
            request.getRequestDispatcher("Review.jsp").forward(request, response);
        }
    }
    public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/PatientDB?serverTimezone=UTC";
		Connection connection=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    connection=DriverManager.getConnection(url,"root","root");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}

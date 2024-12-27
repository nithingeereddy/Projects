package app.net.Controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.net.Model.*;

@WebServlet("/AddPatient")
public class AddPatient extends HttpServlet {
    private static final long serialVersionUID = 1L;
    List<Patient> patientList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int patientNo = Integer.parseInt(request.getParameter("patientNo"));
        String patientName = request.getParameter("patientName");
        String location = request.getParameter("location");
        String issue = request.getParameter("healthIssue");
        String contact = request.getParameter("contact");
       
        Patient patient = new Patient(patientNo, patientName, location, issue, contact);
        patientList.add(patient);
        request.setAttribute("patientList", patientList);

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            ps = con.prepareStatement("insert into patientDetails(pNo,name,location,issue,contact) values(?,?,?,?,?)");
            ps.setInt(1, patientNo);
            ps.setString(2, patientName);
            ps.setString(3, location);
            ps.setString(4, issue);
            ps.setString(5, contact);
            int n = ps.executeUpdate();
            if (n > 0) {
                System.out.println("Success");
                response.sendRedirect("Bookings");
            } else {
                System.out.println(" Failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

  


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/PatientDB?serverTimezone=UTC";
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, "root", "");
        return con;
    }
}

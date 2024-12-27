<%@ page import="java.util.List" %>
<%@ page import="app.net.Model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Vehicle History</title>
    <link rel="stylesheet" type="text/css" href="Bookings.css">
</head>
<body>
    <%@ include file="Navbar.jsp" %>
    <h1>Patient Appointments</h1>
    <table>
        <tr>
            <th>Patient No</th>
            <th>Patient Name</th>
            <th>Location</th>
            <th>Issue</th>
            <th>Contact</th>
            <th>Action</th>
        </tr>
        <% 
            List<Patient> patientList = (List<Patient>) request.getAttribute("patientList");
            if (patientList != null) {
                for (Patient patient : patientList) { 
        %>
            <tr>
                <td><%= patient.getPatientNo() %></td>
                <td><%= patient.getPatientName() %></td>
                <td><%= patient.getLocation() %></td>
                <td><%= patient.getIssue() %></td>
                <td><%= patient.getContact() %></td>

                <td>
                   <form action="cancelPatient" method="get">
  				   <input type="hidden" name="patientNo" value="<%= patient.getPatientNo() %>">
					 <button type="submit" class="delete-btn">Cancel Appointment</button>
</form>
                </td>
            </tr>
        <% 
                } 
            } 
        %>
    </table>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%if(session==null || session.getAttribute("name")==null){
response.sendRedirect("Login.jsp");
return;
}
	%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Appointment Management</title>
    <link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
    <%@ include file="Navbar.jsp" %>
    <div class="container">
        <h1>Welcome to Patient Appointment Management </h1>
        <p>This portal helps you to book an appointment as per your flexibility.</p>
        <button onclick="window.location.href='BookAppointment.jsp'">Book an Appointment</button>
    </div>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Patient</title>
    <link rel="stylesheet" href="BookAppointment.css">
</head>
<body>
<%@include file="Navbar.jsp" %>
    <header>
        <h1>Add Patient</h1>
    </header>
    <main>
        <form action="AddPatient" method="post">
            <label for="patientNo">Patient Number:</label>
            <input type="text" id="patientNo" name="patientNo" required><br><br>
            
            <label for="patientName">Patient Name:</label>
            <input type="text" id="patientName" name="patientName" required><br><br>
            
            <label for="location">Location:</label>
            <input type="text" id="location" name="location" required><br><br>
            
            <label for="healthIssue">Health Issue:</label>
            <textarea id="healthIssue" name="healthIssue" required></textarea><br><br>
            
            <label for="contact">Contact:</label>
            <input type="text" id="contact" name="contact" required><br><br>
            
            <input type="submit" value="Add Patient">
        </form>
    </main>
</body>
</html>
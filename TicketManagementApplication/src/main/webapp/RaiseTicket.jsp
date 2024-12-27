<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submit Ticket - Ticket Management Application</title>
    <link rel="stylesheet" type="text/css" href="RaiseTicket.css">
</head>
<body>
<%@include file="Header.jsp" %> 
    <div class="container">
        <h2>Submit a Ticket</h2>
        <form action="raiseTicket" method="post">
        <label>Ticket id:</label><input type="text" name="ticketId" >
            <label for="ticketType">Ticket Type:</label>
            <select id="ticketType" name="ticketType" required>
                <option value="">Select Ticket Type</option>
                <option value="Bug">Bug</option>
                <option value="Feature Request">Feature Request</option>
                <option value="Other">Other</option>
            </select>

            <label for="priority">Priority:</label>
            <select id="priority" name="priority" required>
                <option value="">Select Priority</option>
                <option value="High">High</option>
                <option value="Medium">Medium</option>
                <option value="Low">Low</option>
            </select>

            <label for="issueDetails">Issue Details:</label>
            <textarea id="issueDetails" name="issueDetails" rows="4" required></textarea>

            <label for="employeeName">Employee Name:</label>
            <input type="text" id="employeeName" name="employeeName" required>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="com.app.model.TicketData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Ticket Status</title>
    <link rel="stylesheet" type="text/css" href="Status.css">
</head>
<body>
    <%@ include file="Header.jsp" %>
    <h1>Ticket Status</h1>
    <table>
        <tr>
            <th>Ticket ID</th>
            <th>Type</th>
            <th>Priority</th>
            <th>Issue Details</th>
            <th>Employee Name</th>
            <th>Action</th>
        </tr>
        <% 
            List<TicketData> ticketList = (List<TicketData>) request.getAttribute("ticketList");
            if (ticketList != null) {
                for (TicketData ticket : ticketList) { 
        %>
            <tr>
                <td><%= ticket.getTicketId() %></td>
                <td><%= ticket.getType() %></td>
                <td><%= ticket.getPriority() %></td>
                <td><%= ticket.getIssueDetails() %></td>
                <td><%= ticket.getEmployeeName() %></td>
                <td>
                   <form action="Comments.jsp" method="get">
  				   <input type="hidden" name="ticketNo" value="<%= ticket.getTicketId() %>">
					 <button type="submit" class="comment-btn">Comments on issue</button>
</form>
                </td>
                <td>
                   <form action="deleteTicket" method="get">
  				   <input type="hidden" name="ticketNo" value="<%= ticket.getTicketId() %>">
					 <button type="submit" class="delete-btn">Resolve</button>
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

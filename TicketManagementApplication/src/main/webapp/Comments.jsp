<!DOCTYPE html>
<html>
<head>
    <title>Comments Page</title>
    <link rel="stylesheet" type="text/css" href="Comments.css">
</head>
<body>
<%@ include file="Header.jsp" %>
    <h1>Leave Your Comments</h1>
    <form action="Comments" method="post">
        <label for="comment">Your Comment:</label><br>
        <textarea id="comment" name="comment" rows="4" cols="50"></textarea><br>
        <input type="submit" value="Submit">
        <!-- Ensure the value attribute is enclosed in quotes -->
        <input type="hidden" name="ticketNo" value="<%= request.getParameter("ticketNo") %>" >
        <%
    Boolean status = (Boolean) request.getAttribute("status");
    if (status != null && status) {
        out.println("Comment Saved successfully");
    }
%>

    </form>
</body>
</html>

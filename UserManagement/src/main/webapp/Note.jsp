<!DOCTYPE html>
<html>
<head>
    <title>Note Page</title>
    <link rel="stylesheet" type="text/css" href="Note.css">
</head>
<body>
<%@ include file="Header.jsp" %>
    <h1>Leave Your Note</h1>
    <form action="Note" method="post">
        <label for="Note">Note:</label><br>
        <textarea id="note" name="note" rows="4" cols="50"></textarea><br>
        <input type="submit" value="Submit">
        <!-- Ensure the value attribute is enclosed in quotes -->
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>" >
        <%
    Boolean status = (Boolean) request.getAttribute("status");
    if (status != null && status) {
        out.println("Comment Saved successfully");
    }
%>

    </form>
</body>
</html>

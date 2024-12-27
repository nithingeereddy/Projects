<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Review Page</title>
    <link rel="stylesheet" href="Reviews.css">
</head>
<body>
<%@ include file="Navbar.jsp" %>
    <div class="container">
        <h1>Review Page</h1>
        <form action="Review" method="post">
            <label for="patientNo">Patient Number:</label>
            <input type="text" id="patientNo" name="patientNo" required><br><br>
            
            <label for="review">Review:</label><br>
            <textarea id="review" name="review" rows="4" cols="50" required></textarea><br><br>
            
            <input type="submit" value="Submit">
            
        <% 
            // Check if reviewSuccess attribute is set
            Boolean reviewSuccess = (Boolean)request.getAttribute("message");
            if (reviewSuccess != null && reviewSuccess) {
        %>
            <p>Thanks for the review!</p>
        <% } %>
        </form>
    </div>
</body>
</html>

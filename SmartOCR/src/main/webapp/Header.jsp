<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link rel="stylesheet" type="text/css" href="Header.css">
</head>
<body>
<nav class="header">
    <div class="header_nav">
        <a href="Home.jsp" class="header_link1A">
            <div class="header_option">
                <span id="active">Home</span>
            </div>
        </a>
        
        <a href="Logout" class="header_link1">
            <div class="header_option">
                <span>Logout</span>
            </div>
        </a>
        <a href="logout" class="header_link1N">
            <div class="header_option">
                <span><%="Welcome "+session.getAttribute("name") %></span>
            </div>
        </a>
    </div>
</nav>

</body>
</html>
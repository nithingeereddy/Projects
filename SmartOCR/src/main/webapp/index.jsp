<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>
<head>
<link rel="stylesheet" href="index.css" type="text/css">
</head>
<body>
<%@ include file="Header.jsp"%>
<div class="body">
<h1>OCR to Extract Customer Data</h1>
<div class="container1">
<img src="Katpro_Logo.jpg" class="logo" alt="Logo">
<form class="form" action="files">
        <input type="text" name="file" class="input-field" placeholder="Enter the Path to extract Fields">
        <input type="submit" value="Submit" class="submit-btn">
</form>
</div>
</div>
<%@ include file="Footer.jsp"%>
</body>

</html>

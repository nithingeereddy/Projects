<%@ page import="java.util.List" %>
<%@ page import="com.katpro.model.CustomerData" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Customer Data</title>
    <link rel="stylesheet" href="table.css" type="text/css">
</head>
<body>
<%@ include file="Header.jsp" %>
   <div class="container"><h1>Customer Data</h1>
    <table class="custom-table" border="1">
        <thead>
            <tr>
                <th>Receipt No</th>
                <th>Name</th>
                <th>Date</th>
                <th>Location</th>
                <th>Tax</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody>
            <% List<CustomerData> customerList = (List<CustomerData>) request.getAttribute("customerList");
                for (CustomerData customer : customerList) { %>
                    <tr>
                        <td><%= customer.getReceiptNo() %></td>
                        <td><%= customer.getName() %></td>
                        <td><%= customer.getDate() %></td>
                        <td><%= customer.getLocation() %></td>
                        <td><%= customer.getTax() %></td>
                        <td><%= customer.getTotal() %></td>
                    </tr>
            <% } %>
        </tbody>
    </table></div>
</body>
</html>

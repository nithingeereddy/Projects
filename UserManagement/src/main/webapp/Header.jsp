<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<style>
    /* Paste your CSS styles here */
    .header {
        background-color: #333;
        padding: 0px;
    }
    .nn {
        padding-top: 35px;
        color: white;
    }
   
    .header_nav {
    display: flex;
    padding: 0; /* Remove padding */
    margin: 0; /* Remove margin */
    background-color: black;
}
    
    .header_link1A {
        padding: 15px;
        text-decoration: none;
        color: white;
        flex-wrap: wrap;
        cursor: pointer;
        text-align: right;
        background-color: #f26711;
    }
    .header_link1N {
        padding: 15px;
        text-decoration: none;
        color: white;
        flex-wrap: wrap;
        cursor: pointer;
        text-align: right;
    }
    .header_link1A:hover {
        background-color: gray;
    }
    .header_link1 {
        padding: 15px;
        text-decoration: none;
        color: white;
        flex-wrap: wrap;
        cursor: pointer;
        text-align: right;
    }
    .header_link1:hover {
        background-color: #111;
    }
    .header_link {
        padding: 15px;
        text-decoration: none;
        color: white;
        flex-wrap: wrap;
        cursor: pointer;
    }
    .header_link:hover {
        background-color: #111;
    }
</style>
</head>
<body>
<nav class="header">
    <div class="header_nav">
        <a href="user-form.jsp" class="header_link1A">
            <div class="header_option">
                <span id="active">Home</span>
            </div>
        </a>
        <a href="About.jsp" class="header_link1">
            <div class="header_option">
                <span>About</span>
            </div>
        </a>
        <a href="javascript:void(0);" onclick="confirmLogout()" class="header_link1">
    <div class="header_option">
        <span>Logout</span>
    </div>
</a>

<script>
    function confirmLogout() {
        var confirmLogout = confirm("Are you sure you want to logout?");
        if (confirmLogout) {
            window.location.href = "logout";
        }
    }
</script>

        <a href="" class="header_link1N">
            <div class="header_option">
                <span><%= "Welcome " + session.getAttribute("name") %></span>
            </div>
        </a>
    </div>
</nav>
</body>
</html>

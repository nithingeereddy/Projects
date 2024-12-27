<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        @charset "UTF-8";
       body {
            padding-top:80px;
            font-family: Arial, sans-serif;
            background-image: url('https://img.freepik.com/free-vector/elegant-dark-background-with-golden-details_23-2148415290.jpg?w=996&t=st=1713458278~exp=1713458878~hmac=93c78c485eaf6f19d1b16e616a985029d79d98f68b5d099ce3004d9ab61e4559');
            background-size: cover;
            background-position: center;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding-bottom: 200px;
        }

        .login_container {
            width: 350px;
            background-color: white;
            display: flex;
            height: fit-content;
            flex-direction: column;
            padding: 30px;
            border: 1px solid lightgray;
        }

        .login_container > h1 {
            font-weight: 1000;
            margin-bottom: -5px;
        }

        .login_container > form > input {
            height: 30px;
            margin-bottom: 10px;
            width: 100%;
            font-size: 14pt;
        }

        .login_signInButton {
            background-color: black;
            border-radius: 5px;
            width: 100%;
            height: 40px;
            border: 1px solid;
            color: white;
            font-weight: 200;
            font-size: large;
            margin-top: 10px;
        }

        .login_signInButton:hover {
            color: #D8BFD8;
        }

 

        .login_container > form > input:hover {
            background-color: whitesmoke ;
        }
    </style>
</head>
<body>
    <div class="login">
        <div class="login_container"> 
        <h1>User Management</h1>
            <img src="https://assets-global.website-files.com/617b1b1f42c1da41aeae3413/6356d3560e785fe354807ccc_user_management_reporting.png" alt="imagee">
            <h1>Login</h1>
            <form action="Login" method="post">
                <br><input type="text" name="username" placeholder="Username" class="login_input"><br>
                <br><input type="password" name="password" placeholder="Password" class="login_input"><br>
                <br><input type="submit" value="Login" class="login_signInButton">
            </form>
            <p>New user? <a href="Register.jsp" class="login_registerButton">Register here</a></p>
        </div>
    </div>
</body>
</html>

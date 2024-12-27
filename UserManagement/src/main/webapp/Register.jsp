<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="Register.css">
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
        .register_container {
            width: 350px;
            background-color: white;
            display: flex;
            height: fit-content;
            flex-direction: column;
            padding: 30px;
            border: 1px solid lightgray;
        }
        
        .register_container > h2 {
            font-weight: 1000;
            margin-bottom: -5px;
        }
        
        .register_container > form > input {
            height: 30px;
            margin-bottom: 10px;
            width: 100%;
            font-size: 14pt;
        }
        
        .register_submitButton {
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
        
        .register_submitButton:hover {
            color: #D8BFD8;
        }
        
        .register_container > form > input:hover {
            background-color: whitesmoke;
        }
        
        .register_loginLink {
            height: 30px;
            width: 100%;
            background-color: black;
            border: 1px solid;
            color: white;
            font-weight: 200;
            border-radius: 5px;
            font-size: large;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            line-height: 30px;
            margin-top: 10px;
        }
        
        .register_loginLink:hover {
            color: #D8BFD8;
        }
    </style>
</head>
<body>
    <div class="register_container">
        <h2>Register</h2>
        <form action="Register" method="post">
        <br>
            <input type="text" name="username" placeholder="Username"><br>
            <br><input type="email" name="email" placeholder="Email"><br>
            <br><input type="password" name="password" placeholder="Password"><br>
            <br><input type="password" name="password2" placeholder="Re-enter Password"><br>
            <br><input type="text" name="contact" placeholder="Contact"><br>
            <br><input type="submit" value="Register" class="register_submitButton">
        </form>
        <a href="Login.jsp" class="register_loginLink">Already have an account? Login here</a>
    </div>
</body>
</html>

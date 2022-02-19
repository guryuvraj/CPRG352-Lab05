<%-- 
    Document   : login
    Created on : Feb 18, 2022, 3:12:20 AM
    Author     : guryu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="post">
        <h1>Login</h1>
        <label>Username: </label>
        <input type="text" name="username" value="${user.username}">
        <br>
        <label>Password: </label>
        <input type="password" name="password" value="${user.getPassword()}">
        <br>
        <input type="submit" name="sub" value="Log In">    
        <p>${message}</p>
        </form>
    </body>
</html>

<%-- 
    Document   : home
    Created on : Feb 18, 2022, 3:12:07 AM
    Author     : guryu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h2>Hello ${user.getUsername()}.</h2>
        <a href="login?logout">Log Out</a>
        
    </body>
</html>

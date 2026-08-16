<%-- 
    Document   : signup
    Created on : Jul 28, 2026, 5:25:37 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>abdo institute</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <img src="stack-diplomas-antique-bookshelf-background-generated-by-ai.jpg"
             style="width:70%; height:98vh; float:right;">
        <h1 style="text-align: left;">Abdo institute</h1><br><br>
        <form align ="left" method="POST" action="SignUpServlet">
            username:<input type="text" name="username" value="" /><br><br>
            password:<input type="text" name="password" value="" /><br><br>
            name: <input type="text" name="name" value="" /><br><br>
            email:<input type="text" name="email" value="" /><br><br>
            telephone:<input type="text" name="telephone" value="" /><br><br>
            address:<input type="text" name="address" value="" /><br><br>
            <label for="birthdate">Birth date</label>
            <input type="date" id="birthdate" name="birthdate"><br><br>
            <input type="radio" name="role" value="STUDENT" />student
            <input type="radio" name="role" value="PROFESSOR" />professor<br><br>
            <input type="submit" value="submit" />
        </form>
        <a href="login.jsp" style="text-align: center;">go to login</a><br><br>    
    </body>
</html>

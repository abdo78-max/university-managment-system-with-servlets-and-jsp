<%-- 
    Document   : login
    Created on : Jul 28, 2026, 5:25:25 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>University Management System</title>
    </head>
    <body>
        <img src="stack-diplomas-antique-bookshelf-background-generated-by-ai.jpg"
             style="width:70%; height:98vh; float:right;">
        <form method="POST" action="LogInServlet">
            <h1 style="text-align:left;">Abdo institute</h1><br><br>

            username : <input type="text" name="username" value="" /><br><br>
            password :<input type="password" name="password" value="" /><br><br>
            <%String message = (String) session.getAttribute("message");
                   if (message != null) {%>
            <label> <%=message%></label><br><br>
            <%
                session.removeAttribute("message");
            %>
            <%}%>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>

<%-- 
    Document   : update mark for student
    Created on : Aug 21, 2026, 3:48:02 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>write student id here</title>
    </head>
    <body>
        <form action="GetProfessorStudentsServlet" method="GET">
            <input type="hidden" name="action" value="updatemark" />
            student id: <input type="text" name="studentid" value="" />
            <input type="submit" value="submit" />
        </form>
    </body>
</html>

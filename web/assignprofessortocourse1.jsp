<%-- 
    Document   : assignprofessortocourse1
    Created on : Aug 13, 2026, 12:29:10 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="SearchProfessorById" method="GET">
            Professor id:
            <input type="text" name="professorid">

            <input type="hidden" name="action" value="assign">

            <input type="submit" value="submit">
        </form>
    </body>
</html>

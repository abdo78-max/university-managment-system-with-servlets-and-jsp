<%-- 
    Document   : deleteteaching
    Created on : Aug 17, 2026, 12:22:38 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>enter id to delete professor's courses</title>
    </head>
    <body>

        <form action="SearchProfessorById" action="GET">
            <input type="hidden" name="action" value="delete" />
            professor id : <input type="text" name="professorid" value="" />
            <input type="submit" value="submit" />
        </form>
    </body>
</html>

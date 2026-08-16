<%-- 
    Document   : updateteaching
    Created on : Aug 15, 2026, 5:58:39 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>write id here</title>
    </head>
    <body >
        <form action="SearchProfessorById" method="GET">
            <input type="hidden" name="action" value="updateprofessorteachingcourse" />
            professor id:<input type="text" name="professorid" value="" />
            <%String message = (String) request.getAttribute("message");
                        if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>

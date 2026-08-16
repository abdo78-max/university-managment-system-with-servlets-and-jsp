<%-- 
    Document   : updateprofessor
    Created on : Aug 6, 2026, 12:45:21 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>write professor id</title>
    </head>
    <body>
        <form action = "SearchProfessorById" method="GET">
                        <input type="hidden" name="action" value="update">

            professor id:<input type="text" name="professorid" value="" /><input type="submit" value="applyid" /><br><br>
            
            <%String message = (String) request.getAttribute("message");
                            if (message != null) {%>
            <label> <%=message%></label>
            <%}%>
        </form>
    </body>
</html>

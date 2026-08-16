<%-- 
    Document   : updatestudent
    Created on : Aug 6, 2026, 12:37:57 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>write student id</title>
    </head>
    <body>
        <form action = "SearchStudentById" method="GET">
            student id:<input type="text" name="studentid" value="" /><input type="submit" value="applyid" /><br><br>
            <%String message = (String) request.getAttribute("message");
                if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
        </form>

    </body>
</html>

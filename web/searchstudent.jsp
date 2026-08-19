<%-- 
    Document   : searchstudent
    Created on : Aug 16, 2026, 10:50:20 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>enter student name here to search</title>
    </head>
    <body>
        <form action='SearchStudentByName' method="GET">
        student name:<input type="text" name="studentname" value="" />
             <%String message = (String) request.getAttribute("message");
                            if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
        <input type="submit" value="submit" />
        </form>
    </body>
</html>

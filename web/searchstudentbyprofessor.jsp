<%-- 
    Document   : searchstudentbyprofessor
    Created on : Aug 21, 2026, 6:54:06 PM
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
        <form action="GetProfessorStudentsServlet" method="GET">
            student id : <input type="text" name="studentid" value="" />
            <%String message = (String) request.getAttribute("message");
                        if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>

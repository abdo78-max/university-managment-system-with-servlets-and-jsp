<%-- 
    Document   : searchenrollment
    Created on : Aug 20, 2026, 10:51:18 AM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>search here by student id</title>
    </head>
    <body>
        <form action = "SearchEnrollmentByStudentIdServlet" method="GET">
            student id : <input type="text" name="studentid" value="" />
            <input type="submit" value="submit" />
            <%String message = (String) request.getAttribute("message");
                if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
        </form>
    </body>
</html>

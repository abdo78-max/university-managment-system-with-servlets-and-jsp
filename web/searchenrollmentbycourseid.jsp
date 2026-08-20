<%-- 
    Document   : searchenrollmentbycourseid
    Created on : Aug 20, 2026, 2:23:21 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>search enrollment by course id</title>
    </head>
    <body>
        <form action = "SearchEnrollmentByCourseIdServlet" method="GET">
            course id : <input type="text" name="courseid" value="" />
            <%String message = (String) request.getAttribute("message");
                if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>

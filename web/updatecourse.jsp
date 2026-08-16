<%-- 
    Document   : updatecourse
    Created on : Aug 6, 2026, 12:39:02 PM
    Author     : Compu City
--%>

<%@page import="data.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>write course id</title>
    </head>
    <body>
        <form action = "SearchCourseById" method="GET">
            course id:<input type="text" name="courseid" value="" /><input type="submit" value="applyid" /><br><br>
            <%String message = (String) request.getAttribute("message");
                            if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
        </form>
    </body>
</html>

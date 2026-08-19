<%-- 
    Document   : searchcourse
    Created on : Aug 16, 2026, 10:50:54 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>enter here course name to search</title>
    </head>
    <body>
        <form action="SearchCourseByName" method="GET">
        course name:<input type="text" name="coursename" value="" />
        <input type="submit" value="submit" />
                <%String message = (String) request.getAttribute("message");
                            if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
        </form>
    </body>
</html>

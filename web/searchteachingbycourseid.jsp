<%-- 
    Document   : searchteachingbycourseid
    Created on : Aug 20, 2026, 5:51:27 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>search courses </title>
    </head>
    <body>
        <form action="SearchTeachingByCourseId" method="GET">
          course id : <input type="text" name="courseid" value="" />
            <input type="submit" value="submit" />
            <%String message = (String) request.getAttribute("message");
                if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
       </form>
    </body>
</html>

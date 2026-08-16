<%-- 
    Document   : deletecourse
    Created on : Aug 6, 2026, 12:39:11 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>delete course</title>
    </head>
    <body>
        <form action = "DeleteCourseServlet" method="POST">
            course id:<input type="text" name="courseid" value="" /><input type="submit" value="applyid" /><br><br>
            <%String message = (String) session.getAttribute("message");
                if (message != null) {%>

            <label> <%=message%></label>
            <%
                session.removeAttribute("message");
            %>
            <%}%>
        </form>
    </body>
</html>

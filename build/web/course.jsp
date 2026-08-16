<%-- 
    Document   : course
    Created on : Aug 5, 2026, 6:46:29 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add course</title>
    </head>
    <body>
        <form action="CourseServlet" method="POST">
            course name:<input type="text" name="coursename" value="" /><br><br>
            credit hours:<input type="text" name="credithours" value="" /><br><br>
            <input type="submit" value="submit" /><br><br>
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

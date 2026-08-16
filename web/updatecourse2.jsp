<%-- 
    Document   : updatecourse2
    Created on : Aug 6, 2026, 5:27:49 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update course</title>
    </head>
    <body>
        <form action = "UpdateCourseServlet" method="POST">
            <input type="hidden" name="courseid" value="${course.courseId}" />
            course name:<input type="text" name="coursename" value="${course.courseName}" /><br><br>
            credit hours:<input type="text" name="credithours" value="${course.creditHours}" /><br><br>
            <%String message = (String) session.getAttribute("message");
                if (message != null) {%>
            <label> <%=message%></label><br><br>
            <%
                session.removeAttribute("message");
            %>
            <%}%>
            <input type="submit" value="submit" />
        </form>  
    </body>
</html>

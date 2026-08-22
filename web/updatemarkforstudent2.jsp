<%-- 
    Document   : updatemarkforstudent2
    Created on : Aug 21, 2026, 8:43:22 PM
    Author     : Compu City
--%>

<%@page import="java.util.Set"%>
<%@page import="data.Enrollment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="GetProfessorStudentsServlet" method="GET">
            <input type="hidden" name="action" value="updatemark2" />
            student id : <input type="text" name="studentid" value="${student.id}" readonly="readonly" /><br><br>
            course name : <select name="courseid">
                <%
                    Set<Enrollment> studentCourses = (Set<Enrollment>) session.getAttribute("professorstudents");

                    for (Enrollment enrollment : studentCourses) {
                %>

                <option value="<%=enrollment.getCourse().getCourseId()%>">
                    <%=enrollment.getCourse().getCourseName()%>
                </option>

                <%
                    }
                %>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>

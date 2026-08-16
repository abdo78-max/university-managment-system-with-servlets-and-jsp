<%-- 
    Document   : updateenrollment
    Created on : Aug 13, 2026, 3:19:40 PM
    Author     : Compu City
--%>

<%@page import="java.util.Set"%>
<%@page import="data.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>enter course name</title>
    </head>
    <body>
        <form action = "SearchEnrollmentServlet" method="GET">
            course name:<select name="courseid">
                <%
                    Student student = (Student) request.getSession().getAttribute("student");
                    Set<Course> courses
                            = student.getCourses();

                    for (Course course : courses) {
                %>

                <option value="<%=course.getCourseId()%>">
                    <%=course.getCourseName()%>
                </option>

                <%
                    }
                %>
            </select><br><br>
            <%String message = (String) request.getAttribute("message");
                if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>

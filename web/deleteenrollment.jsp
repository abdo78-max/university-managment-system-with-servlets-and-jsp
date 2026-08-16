<%-- 
    Document   : deleteenrollment
    Created on : Aug 13, 2026, 3:19:56 PM
    Author     : Compu City
--%>

<%@page import="java.util.Set"%>
<%@page import="data.Student"%>
<%@page import="data.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>delete your enrollment here</title>
    </head>
    <body>
    <form action="DeleteEnrollmentServlet" method="POST">
        course name:<select name="courseid">
            <%
                Student student = (Student) session.getAttribute("student");
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
        <%String message = (String) session.getAttribute("message");
            if (message != null) {%>

        <label> <%=message%></label>
        <%
            session.removeAttribute("message");
        %>
        <%}%>
        <input type="submit" value="submit" />
    </form>
</body>
</html>

<%-- 
    Document   : updateenrollment2
    Created on : Aug 13, 2026, 6:44:13 PM
    Author     : Compu City
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="data.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update here your course</title>
    </head>
    <body>
        <form action="UpdateEnrollmentServlet" method="POST">
            <input type="hidden" name="studentid" value="${enrollment.student.id}" readonly/><br><br>
            <input type="hidden" name="courseid1" value="${enrollment.course.courseId}" readonly/>
            course name:<select name="courseid2"><br><br>
                <%

                    ArrayList<Course> courses
                            = (ArrayList<Course>) session.getAttribute("courses");

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
                <label> <%=message%></label><br><br>
                <%
                    session.removeAttribute("message");
                %>
                <%}%>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>

<%-- 
    Document   : enrollment
    Created on : Aug 9, 2026, 6:50:13 PM
    Author     : Compu City
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="data.Course"%>
<%@page import="dao.CourseDao"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>sign in course</title> 
    </head> 
    <body> 
        <form action="AddEnrollmentServlet" method="POST">
            <input type="hidden" name="enrollmentid" value="" />
            <input type="hidden" name="studentid" value="${student.id}" />
            student name : <input type="text" name="studentname" value="${student.name}" /><br><br>
            course name:<select name="courseid">
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

            <label> <%=message%></label>
            <%
                session.removeAttribute("message");
            %>
            <%}%>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>
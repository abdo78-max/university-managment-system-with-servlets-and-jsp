<%-- 
    Document   : deleteteaching2
    Created on : Aug 17, 2026, 6:04:40 PM
    Author     : Compu City
--%>

<%@page import="java.util.Set"%>
<%@page import="data.Course"%>
<%@page import="data.Course"%>
<%@page import="data.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>delete professor's course here</title>
    </head>
    <body> <form action="DeleteTeachingServlet" method="POST">
            <input type="hidden" name="professorid" value="${professor.id}" />
            course name:<select name="courseid"><%
        Professor professor = (Professor) session.getAttribute("professor");
        Set<Course> courses
                = professor.getCourses();

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

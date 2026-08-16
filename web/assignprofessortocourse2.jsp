<%-- 
    Document   : teaching
    Created on : Aug 12, 2026, 7:09:03 PM
    Author     : Compu City
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="data.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>assign professor to course</title>
    </head>
    <body>
        <form action="AssignProfessorToCourseServlet" method="POST">
            <input type="hidden" name="professorid" value="${professor.id}" />
            professor name:<input type="text" name="professorname" value="${professor.name}" readonly/><br><br>
            course name :<select name="courseid">  <%

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

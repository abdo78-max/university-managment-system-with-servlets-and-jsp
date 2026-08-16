<%-- 
    Document   : updateteaching2
    Created on : Aug 15, 2026, 6:18:20 PM
    Author     : Compu City
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Professor"%>
<%@page import="java.util.Set"%>
<%@page import="data.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>choose professor course here to update</title>
    </head>
    <body>
        <form action="UpdateTeachingServlet" method="POST">
            <input type="hidden" name="professorid" value="${professor.id}" />

            old course name:   <select name="courseid1"><%
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
            new course name:<select name="courseid2">
                <%
                    ArrayList<Course> allcourses
                            = (ArrayList<Course>) session.getAttribute("courses");

                    for (Course course : allcourses) {
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

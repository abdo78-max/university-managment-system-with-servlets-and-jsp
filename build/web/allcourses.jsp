<%-- 
    Document   : allcourses
    Created on : Aug 10, 2026, 12:23:33 PM
    Author     : Compu City
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="data.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view courses</title>
    </head>
    <body>
        <form action="ViewAllCoursesServlet">
            course name:<select name="">

                <%
                    ArrayList<Course> courses = (ArrayList<Course>) request.getAttribute("courses");
                    for (Course course : courses) {
                %>
                <option>
                    <%=course.getCourseName()%>
                </option>
                <%}%>
            </select>
        </form>
    </body>
</html>

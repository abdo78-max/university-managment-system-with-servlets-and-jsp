<%-- 
    Document   : searchcourse2
    Created on : Aug 18, 2026, 1:14:08 PM
    Author     : Compu City
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="data.Course"%>
<%@page import="data.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>course data</title>
    </head>
    <body>
            <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>course name</th>
                    <th>credit hours</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("courses");
                    for (Course course : courses) {
                %>
                <tr>
                    <td><%=course.getCourseId()%></td>
                    <td><%=course.getCourseName()%></td>
                    <td><%=course.getCreditHours()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

<%-- 
    Document   : professorstudents
    Created on : Aug 21, 2026, 6:12:22 PM
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
        <table border="1">
            <thead>
                <tr>
                    <th>student id</th>
                    <th>course id</th>
                    <th>student name</th>
                    <th>course name</th>
                    <th>mark<th>
                </tr>
            </thead>
            <tbody>
                <%
                    Set<Enrollment> professorStudents = (Set<Enrollment>) session.getAttribute("professorstudents");
                    for (Enrollment enrollment : professorStudents) {
                %>
                <tr>
                    <td><%=enrollment.getStudent().getId()%></td>
                    <td><%=enrollment.getCourse().getCourseId()%></td>
                    <td><%=enrollment.getStudent().getName()%></td>
                    <td><%=enrollment.getCourse().getCourseName()%></td>
                    <td><%=enrollment.getMark()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

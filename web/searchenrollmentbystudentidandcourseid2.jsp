<%-- 
    Document   : searchenrollmentbystudentid2
    Created on : Aug 20, 2026, 12:05:47 PM
    Author     : Compu City
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="data.Enrollment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>enrollments</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>enrollment id</th>
                    <th>student id</th>
                    <th>course id</th>
                    <th>student name</th>
                    <th>course name</th>
                    <th>birth date</th>
                    <th>enrollment date</th>
                    <th>phone</th>
                    <th>mark<th>
                    <th>email<th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Enrollment> studentEnrollments = (ArrayList<Enrollment>) session.getAttribute("enrollments");
                    for (Enrollment enrollment : studentEnrollments) {
                %>
                <tr>
                    <td><%=enrollment.getEnrollmentId()%></td>
                    <td><%=enrollment.getStudent().getId()%></td>
                    <td><%=enrollment.getCourse().getCourseId()%></td>
                    <td><%=enrollment.getStudent().getName()%></td>
                    <td><%=enrollment.getCourse().getCourseName()%></td>
                    <td><%=enrollment.getStudent().getBirthDate()%></td>
                    <td><%=enrollment.getEnrollmentDate()%></td>
                    <td><%=enrollment.getStudent().getPhone()%></td>
                    <td><%=enrollment.getMark()%></td>
                    <td><%=enrollment.getStudent().getEmail()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

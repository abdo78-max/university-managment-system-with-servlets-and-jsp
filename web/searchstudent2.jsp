<%-- 
    Document   : searchstudent2
    Created on : Aug 18, 2026, 12:29:33 PM
    Author     : Compu City
--%>

<%@page import="data.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>the students data</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>email</th>
                    <th>phone</th>
                    <th>address</th>
                    <th>birth date</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("students");
                    for (Student student : students) {
                %>
                <tr>
                    <td><%=student.getId()%></td>
                    <td><%=student.getName()%></td>
                    <td><%=student.getEmail()%></td>
                    <td><%=student.getPhone()%></td>
                    <td><%=student.getAddress()%></td>
                    <td><%=student.getBirthDate()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

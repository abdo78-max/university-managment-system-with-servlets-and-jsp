<%-- 
    Document   : searchprofessor2
    Created on : Aug 18, 2026, 5:35:16 PM
    Author     : Compu City
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="data.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>professor data</title>
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
                    <th>specialization</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Professor> professors = (ArrayList<Professor>) session.getAttribute("professors");
                    for (Professor professor : professors) {
                %>
                <tr>
                    <td><%=professor.getId()%></td>
                    <td><%=professor.getName()%></td>
                    <td><%=professor.getEmail()%></td>
                    <td><%=professor.getPhone()%></td>
                    <td><%=professor.getAddress()%></td>
                    <td><%=professor.getBirthDate()%></td>
                    <td><%=professor.getSpecialization()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

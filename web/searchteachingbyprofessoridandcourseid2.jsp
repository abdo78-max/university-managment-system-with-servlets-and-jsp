<%-- 
    Document   : searchteachingbyprofessoridandcourseid2
    Created on : Aug 20, 2026, 5:53:40 PM
    Author     : Compu City
--%>

<%@page import="data.Teaching"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>teaching data</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>professor id</th>
                    <th>course id</th>
                    <th>professor name</th>
                    <th>course name</th>
                    <th>birth date</th>
                    <th>specialization</th>
                    <th>phone</th>
                    <th>email</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Teaching> teachingList = (ArrayList<Teaching>) session.getAttribute("teaching");
                    for (Teaching teaching : teachingList) {
                %>
                <tr>
                    <td><%=teaching.getProfessor().getId()%></td>
                    <td><%=teaching.getCourse().getCourseId()%></td>
                    <td><%=teaching.getProfessor().getName()%></td>
                    <td><%=teaching.getCourse().getCourseName()%></td>
                    <td><%=teaching.getProfessor().getBirthDate()%></td>
                    <td><%=teaching.getProfessor().getSpecialization()%></td>
                    <td><%=teaching.getProfessor().getPhone()%></td>
                    <td><%=teaching.getProfessor().getEmail()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

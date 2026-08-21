<%-- 
    Document   : professor
    Created on : Jul 28, 2026, 8:17:36 PM
    Author     : Compu City
--%>

<%@page import="data.Student"%>
<%@page import="java.util.Set"%>
<%@page import="data.Course"%>
<%@page import="data.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>professor page</title>
    </head>
    <body>
        professor id:${professor.id}<br><br>
        professor name:${professor.name}<br><br>
        courses:<%
            Professor professor = (Professor) session.getAttribute("professor");
            Set<Course> courses = professor.getCourses();

            for (Course course : courses) {
        %>

        <%= course.getCourseName()%><br>

        <%
            }
        %><br><br>
        <a href="searchstudentbyprofessor.jsp" style="text-align: center;">search student here</a><br><br>    
        <a href="updatemarkforstudent.jsp" style="text-align: center;">update mark</a><br><br>    
    </body>
</html>

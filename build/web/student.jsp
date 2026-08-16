<%-- 
    Document   : student
    Created on : Jul 28, 2026, 8:17:27 PM
    Author     : Compu City
--%>

<%@page import="java.util.Set"%>
<%@page import="data.Course"%>
<%@page import="data.Course"%>
<%@page import="data.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>student Page</title>
    </head>
    <body>
        student id : ${student.id}<br><br>
        student name: ${student.name}<br><br>
        phone :${student.phone} <br><br>
        address :${student.address}<br><br>
        email:${student.email}<br><br>
        enrolled courses : <%
            Student student = (Student) session.getAttribute("student");
            Set<Course> courses = student.getCourses();

            for (Course course : courses) {
        %>

        <%= course.getCourseName()%><br><br>

        <%
            }
        %>
        <a href="enrollment.jsp" style="text-align: center;">enroll courses here</a><br><br>
        <a href="updateenrollment.jsp" style="text-align: center;">update enrollment here</a><br><br>
        <a href="deleteenrollment.jsp" style="text-align: center;">delete enrollment here</a><br><br>

    </body>
</html>

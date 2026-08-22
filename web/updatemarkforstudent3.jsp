<%-- 
    Document   : updatemarkforstudent3
    Created on : Aug 22, 2026, 4:22:04 PM
    Author     : Compu City
--%>

<%@page import="data.Enrollment"%>
<%@page import="data.Course"%>
<%@page import="data.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="jakarta.faces.html" xmlns:f="jakarta.faces.core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UpdateMarkServlet" method="POST"/>
        student id:<input type="text" name="studentid" value="${student.id}" readonly="readonly" /><br><br>
        course id :<input type="text" name="courseid" value="${course.courseId}" readonly="readonly" />
        mark : 
        <input type = "text" name = "mark" value = "<%=session.getAttribute("enrollmentmark")%>"/>
        <form/>
        <input type="submit" value="submit" />
        <%String message = (String) session.getAttribute("message");
            if (message != null) {%>

        <label> <%=message%></label>
        <%
            session.removeAttribute("message");
        %>
        <%}%>

    </body>
</html>

<%-- 
    Document   : updatestudent2
    Created on : Aug 8, 2026, 1:14:57 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update student</title>
    </head>
    <body>

        <form action = "UpdateStudentServlet" method="POST">
            <input type="hidden" name="studentid" value="${student.id}" />

            student name:<input type="text" name="studentname" value="${student.name}" /><br><br>
            email:<input type="text" name="email" value="${student.email}" /><br><br>
            phone:<input type="text" name="phone" value="${student.phone}" /><br><br>
            address:<input type="text" name="address" value="${student.address}" /><br><br>
            <label for="birthdate">Birth date</label>
            <input type="date" id="birthdate" name="birthdate" value="${student.birthDate}"><br><br>
            <%String message = (String) session.getAttribute("message");

                if (message != null) {%>
            <label> <%=message%></label><br><br>
            <%
                session.removeAttribute("message");
            %>
            <%}%>
            <input type="submit" value="submit" />
        </form>  
    </body>
</html>

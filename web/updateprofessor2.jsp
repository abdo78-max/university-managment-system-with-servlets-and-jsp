<%-- 
    Document   : updateprofessor2
    Created on : Aug 7, 2026, 12:21:39 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update professor</title>
    </head>
    <body>
        <form action = "UpdateProfessorServlet" method="POST">
            <input type="hidden" name="professorid" value="${professor.id}" />

            professor name:<input type="text" name="professorname" value="${professor.name}" /><br><br>
            specialization:<input type="text" name="specialization" value="${professor.specialization}" /><br><br>            
            email:<input type="text" name="email" value="${professor.email}" /><br><br>
            phone:<input type="text" name="phone" value="${professor.phone}" /><br><br>
            address:<input type="text" name="address" value="${professor.address}" /><br><br>
            <label for="birthdate">Birth date</label>
            <input type="date" id="birthdate" name="birthdate" value="${professor.birthDate}"><br><br>
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

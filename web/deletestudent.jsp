<%-- 
    Document   : deletestudent
    Created on : Aug 6, 2026, 12:38:51 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>delete student id</title>
    </head>
    <body>
        <form action = "DeleteStudentServlet" method="POST">
            student id:<input type="text" name="studentid" value="" /><input type="submit" value="applyid" /><br><br>
            <%String message = (String) session.getAttribute("message");
                if (message != null) {%>

            <label> <%=message%></label>
            <%
                session.removeAttribute("message");
            %>
            <%}%>
        </form>
    </body>
</html>

<%-- 
    Document   : deleteprofessor
    Created on : Aug 8, 2026, 4:33:23 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>delete professor</title>
    </head>
    <body>
        <form action = "DeleteProfessorServlet" method="POST">
            professor id:<input type="text" name="professorid" value="" /><input type="submit" value="applyid" /><br><br>

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

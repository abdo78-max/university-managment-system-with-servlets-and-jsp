<%-- 
    Document   : searchteachinbyprofessorid
    Created on : Aug 20, 2026, 5:50:13 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>enter professor id here</title>
    </head>
    <body>
        <form action="SearchTeachingByProfessorIdServlet" method="GET">
            professor id : <input type="text" name="professorid" value="" />
            <input type="submit" value="submit" />
            <%String message = (String) request.getAttribute("message");
                if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
        </form>
    </body>
</html>

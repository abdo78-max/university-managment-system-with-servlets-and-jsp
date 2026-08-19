<%-- 
    Document   : searchprofessor
    Created on : Aug 16, 2026, 10:50:39 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>enter here professor name to search</title>
    </head>
    <body>
          <form action="SearchProfessorByName" method="GET">
        professor name:<input type="text" name="professorname" value="" />
        <input type="submit" value="submit" />
                <%String message = (String) request.getAttribute("message");
                            if (message != null) {%>

            <label> <%=message%></label>
            <%}%>
        </form>
    </body>
</html>

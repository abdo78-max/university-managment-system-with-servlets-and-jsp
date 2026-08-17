<%-- 
    Document   : manager
    Created on : Jul 28, 2026, 8:21:10 PM
    Author     : Compu City
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>dashboard</title>

    <h3>عدد الطلاب</h3>
    <%=session.getAttribute("studentcounter")%><br><br>


    <h3>عدد الدكاترة</h3>

    <%=session.getAttribute("professorcounter")%><br><br>

    <h3>عدد الكورسات</h3>
    <%=session.getAttribute("coursecounter")%><br><br>
    <a href="course.jsp" style="text-align: center;">go to add course</a><br><br>    
    <a href="updatecourse.jsp" style="text-align: center;">go to update course</a><br><br>    
    <a href="deletecourse.jsp" style="text-align: center;">go to delete course</a><br><br>    
    <a href="updatestudent.jsp" style="text-align: center;">go to update student</a><br><br>    
    <a href="deletestudent.jsp" style="text-align: center;">go to delete student</a><br><br>    
    <a href="updateprofessor.jsp" style="text-align: center;">go to update professor</a><br><br>    
    <a href="deleteprofessor.jsp" style="text-align: center;">go to delete professor</a><br><br>    
    <a href="assignprofessortocourse1.jsp" style="text-align: center;">assign professor to course</a><br><br>    
    <a href="updateteaching.jsp" style="text-align: center;">update the professor's teaching course</a><br><br>    
    <a href="searchstudent.jsp" style="text-align: center;">search student here</a><br><br>    
    <a href="searchprofessor.jsp" style="text-align: center;">search professor here</a><br><br>    
    <a href="searchcourse.jsp" style="text-align: center;">search course here</a><br><br>    
    <a href="deleteteaching.jsp" style="text-align: center;">delete professor's teaching course here</a><br><br>    

</head>
<body>
</body>
</html>

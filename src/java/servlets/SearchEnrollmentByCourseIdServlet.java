/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.EnrollmentDao;
import data.Course;
import data.Enrollment;
import data.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Compu City
 */
public class SearchEnrollmentByCourseIdServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection connect = (Connection) getServletContext().getAttribute("db connection");
        String courseId = request.getParameter("courseid");
        String message = (String) request.getAttribute("message");
        if (message != null) {
            request.getRequestDispatcher("searchenrollmentbycourseid.jsp").forward(request, response);
            return;
        }
        Course course = new Course(Integer.parseInt(courseId));
        Enrollment enrollment = new Enrollment(course);
        EnrollmentDao enrollmentDao = new EnrollmentDao(connect);
        ArrayList<Enrollment> selectedEnrollments = enrollmentDao.searchEnrollmentByCourseId(enrollment);
        if (!selectedEnrollments.isEmpty()) {
            request.getSession().setAttribute("enrollments", selectedEnrollments);
            request.getRequestDispatcher("searchenrollmentbystudentidandcourseid2.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "the enrollments is empty");
            request.getRequestDispatcher("searchenrollmentbycourseid.jsp").forward(request, response);
        }
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SearchEnrollmentByCourseIdServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SearchEnrollmentByCourseIdServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

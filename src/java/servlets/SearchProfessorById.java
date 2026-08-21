/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.ProfessorDao;
import data.Professor;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;

/**
 *
 * @author Compu City
 */
public class SearchProfessorById extends HttpServlet {

    String message = null;

    public void forwardByAction(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
        if ("assign".equalsIgnoreCase(action)) {
            if (message == null) {
                request.setAttribute("message", "professor is not found");
            }
            request.getRequestDispatcher("assignprofessortocourse1.jsp").forward(request, response);
        } else if ("updateprofessorteachingcourse".equals(action)) {
            if (message == null) {
                request.setAttribute("message", "professor is not found");
            }
            request.getRequestDispatcher("updateteaching.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            if (message == null) {
                request.setAttribute("message", "professor is not found");
            }
            request.getRequestDispatcher("deleteteaching.jsp").forward(request, response);
        } else if ("updateprofessor".equals(action)) {
            if (message == null) {
                request.setAttribute("message", "professor is not found");
            }
            request.getRequestDispatcher("updateprofessor.jsp").forward(request, response);
        }
    }

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
        String professorId = request.getParameter("professorid");
        String action = request.getParameter("action");
        message = (String) request.getAttribute("message");
        if (message != null) {
            try {
                forwardByAction(request, response, action);
            } catch (ServletException | IOException exception) {
                exception.printStackTrace();
            }
            return;
        }
        ProfessorDao professorDao = new ProfessorDao(connect);
        Professor professor = new Professor(Integer.parseInt(professorId));
        Professor selectedProfessor = professorDao.searchProfessorById(professor);
        if (selectedProfessor != null) {
            request.getSession().setAttribute("professor", selectedProfessor);
            if ("assign".equalsIgnoreCase(action)) {
                request.getRequestDispatcher("assignprofessortocourse2.jsp").forward(request, response);
            } else if ("updateprofessorteachingcourse".equalsIgnoreCase(action)) {
                request.getRequestDispatcher("GetProfessorCoursesServlet").forward(request, response);
            } else if ("delete".equalsIgnoreCase(action)) {
                request.getRequestDispatcher("GetProfessorCoursesServlet").forward(request, response);
            } else if ("updateprofessor".equalsIgnoreCase(action)) {
                request.getRequestDispatcher("updateprofessor2.jsp").forward(request, response);
            }
        } else {
            try {
                forwardByAction(request, response, action);
            } catch (ServletException | IOException exception) {
                exception.printStackTrace();
            }
        }
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SearchProfessorById</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SearchProfessorById at " + request.getContextPath() + "</h1>");
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

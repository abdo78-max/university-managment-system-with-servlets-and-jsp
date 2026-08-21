/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.ProfessorDao;
import dao.StudentDao;
import data.Professor;
import data.Role;
import data.Student;
import data.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.time.LocalDate;
import services.UserService;

/**
 *
 * @author Compu City
 */
public class SignUpServlet extends HttpServlet {

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        String birthDate = request.getParameter("birthdate");
        String role = request.getParameter("role");
        Role userRole = Role.valueOf(role);
        if (telephone.length() != 11) {
            request.setAttribute("message", "phone should be numbers and 11 digits");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        } else {
            for (int i = 0; i < telephone.length(); i++) {
                if (!Character.isDigit(telephone.charAt(i))) {
                    request.setAttribute("message", "phone should be 11 only numbers");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                    return;
                }
            }
        }
        if (userRole == Role.PROFESSOR) {
            ProfessorDao professorDao = new ProfessorDao(connect);
            UserService userService = new UserService(connect);
            Professor professor = new Professor(name, email, address, LocalDate.parse(birthDate), telephone);
            User user = new User(username, password, professor, userRole);
            int resultProf = professorDao.addProfessor(professor);
            int resultUser = userService.addUser(user);
            if (resultProf == 1 && resultUser == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("professor", professor);
                response.sendRedirect("professor.jsp");
            }
        } else if (userRole == Role.STUDENT) {
            StudentDao studentDao = new StudentDao(connect);
            UserService userService = new UserService(connect);
            Student student = new Student(name, email, address, LocalDate.parse(birthDate), telephone);
            User user = new User(username, password, student, userRole);
            int resultStudent = studentDao.addStudent(student);
            int resultUser = userService.addUser(user);
            if (resultStudent == 1 && resultUser == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("student", student);
                response.sendRedirect("ViewAllCoursesServlet");
            }
        }
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SignUpServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SignUpServlet at " + request.getContextPath() + "</h1>");
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

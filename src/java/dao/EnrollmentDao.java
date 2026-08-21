/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import data.Course;
import data.Enrollment;
import data.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Compu City
 */
public class EnrollmentDao {

    private Connection connection;
    private String sql;

    public EnrollmentDao(Connection connection) {
        this.connection = connection;
    }

    public int addEnrollment(Enrollment enrollment) {
        int result = 0;
        sql = "insert into `student-course` (studentid,courseid,enrollmentdate,mark)values(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, enrollment.getStudent().getId());
            preparedStatement.setInt(2, enrollment.getCourse().getCourseId());
            preparedStatement.setDate(3, java.sql.Date.valueOf(enrollment.getEnrollmentDate()));
            preparedStatement.setDouble(4, enrollment.getMark());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateEnrollment(Enrollment enrollment, Course course) {
        int result = 0;
        sql = "update `student-course` set courseid = ? where studentid=? and courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, course.getCourseId());
            preparedStatement.setInt(2, enrollment.getStudent().getId());
            preparedStatement.setInt(3, enrollment.getCourse().getCourseId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Enrollment searchEnrollment(Enrollment enrollment) {
        sql = "select studentid,courseid from `student-course` where studentid=? and courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, enrollment.getStudent().getId());
            preparedStatement.setInt(2, enrollment.getCourse().getCourseId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int studentId = resultSet.getInt("studentid");
                    int courseId = resultSet.getInt("courseid");
                    Student student = new Student(studentId);
                    Course course = new Course(courseId);
                    return new Enrollment(student, course);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int deleteEnrollment(Enrollment enrollment) {
        int result = 0;
        sql = "delete from `student-course` where studentid=? and courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, enrollment.getStudent().getId());
            preparedStatement.setInt(2, enrollment.getCourse().getCourseId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int countEnrollments() {
        int count = 0;
        sql = "select count(*) as 'total enrollments' from `student-course`";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public ArrayList<Enrollment> searchEnrollmentByStudentId(Enrollment enrollment) {
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        sql = "select enrollmentid,coursename,birthdate,enrollmentdate,email,mark,phone,sc.studentid,sc.courseid,studentname from student s join `student-course` sc on s.studentid=sc.studentid join course c on c.courseid=sc.courseid where sc.studentid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, enrollment.getStudent().getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int enrollmentId = resultSet.getInt("enrollmentid");
                    int studentId = resultSet.getInt("studentid");
                    int courseId = resultSet.getInt("courseid");
                    String studentName = resultSet.getString("studentname");
                    String courseName = resultSet.getString("coursename");
                    LocalDate enrollmentDate = resultSet.getDate("enrollmentdate").toLocalDate();
                    LocalDate birthDate = resultSet.getDate("birthdate").toLocalDate();
                    double mark = resultSet.getDouble("mark");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    Student student = new Student(studentId, studentName, email, birthDate, phone);
                    Course course = new Course(courseId, courseName);
                    enrollments.add(new Enrollment(enrollmentId, student, course, enrollmentDate, mark));
                }
                return enrollments;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Enrollment> searchEnrollmentByCourseId(Enrollment enrollment) {
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        sql = "select enrollmentid,studentname,phone,email,birthdate,coursename,enrollmentdate,mark,sc.studentid,sc.courseid from student s join `student-course` sc on s.studentid=sc.studentid join course c on c.courseid=sc.courseid where sc.courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, enrollment.getCourse().getCourseId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int enrollmentId = resultSet.getInt("enrollmentid");
                    int studentId = resultSet.getInt("studentid");
                    int courseId = resultSet.getInt("courseid");
                    String studentName = resultSet.getString("studentname");
                    String courseName = resultSet.getString("coursename");
                    LocalDate enrollmentDate = resultSet.getDate("enrollmentdate").toLocalDate();
                    LocalDate birthDate = resultSet.getDate("birthdate").toLocalDate();
                    double mark = resultSet.getDouble("mark");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    Student student = new Student(studentId, studentName, email, birthDate, phone);
                    Course course = new Course(courseId, courseName);
                    enrollments.add(new Enrollment(enrollmentId, student, course, enrollmentDate, mark));
                }
                return enrollments;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       public int updateMark(Enrollment enrollment, Course course) {
        int result = 0;
        sql = "update `student-course` set mark = ? where studentid=? and courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, enrollment.getMark());
            preparedStatement.setInt(2, enrollment.getStudent().getId());
            preparedStatement.setInt(3, enrollment.getCourse().getCourseId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}

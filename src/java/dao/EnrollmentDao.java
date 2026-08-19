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
        sql = "update `student-course` set courseid = ?,enrollmentdate=? where studentid=? and courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, course.getCourseId());
            preparedStatement.setDate(2, java.sql.Date.valueOf(enrollment.getEnrollmentDate()));
            preparedStatement.setInt(3, enrollment.getStudent().getId());
            preparedStatement.setInt(4, enrollment.getCourse().getCourseId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Enrollment SearchEnrollment(Enrollment enrollment) {
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

    public int DeleteEnrollment(Enrollment enrollment) {
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
}

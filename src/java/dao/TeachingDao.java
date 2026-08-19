package dao;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import data.Course;
import data.Professor;
import data.Teaching;

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
public class TeachingDao {

    private Connection connection;
    private String sql;

    public TeachingDao(Connection connection) {
        this.connection = connection;
    }

    public int assignProfessorToCourse(Teaching teaching) {
        int result = 0;
        sql = "insert into `professor-course` (professorid,courseid) values(?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, teaching.getProfessor().getId());
            preparedStatement.setInt(2, teaching.getCourse().getCourseId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeachingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateTeaching(Teaching teaching, Course course, Professor professor) {
        int result = 0;
        sql = "update `professor-course` set professorid=?,courseid=? where professorid=? and courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, professor.getId());
            preparedStatement.setInt(2, course.getCourseId());
            preparedStatement.setInt(3, teaching.getProfessor().getId());
            preparedStatement.setInt(4, teaching.getCourse().getCourseId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeachingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Teaching searchTeaching(Teaching teaching) {
        sql = "select professorid,courseid from `professor-course` where professorid=? and courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, teaching.getProfessor().getId());
            preparedStatement.setInt(2, teaching.getCourse().getCourseId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int professorId = resultSet.getInt("professorid");
                    int courseId = resultSet.getInt("courseid");
                    Professor professor = new Professor(professorId);
                    Course course = new Course(courseId);
                    return new Teaching(professor, course);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeachingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int deleteTeaching(Teaching teaching) {
        int result = 0;
        sql = "delete from `professor-course` where professorid=? and courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, teaching.getProfessor().getId());
            preparedStatement.setInt(2, teaching.getCourse().getCourseId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeachingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int countTeaching() {
        int count = 0;
        sql = "SELECT COUNT(DISTINCT professorid) as professorswhoteachcourses FROM `professor-course`";
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

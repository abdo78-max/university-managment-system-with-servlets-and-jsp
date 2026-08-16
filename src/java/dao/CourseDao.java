/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import data.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Compu City
 */
public class CourseDao {

    private Connection connection;
    private String sql;

    public CourseDao(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Course> viewCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        sql = "select * from university.course";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int courseId = resultSet.getInt("courseid");
                String courseName = resultSet.getString("courseName");
                int creditHours = resultSet.getInt("credit_hours");
                courses.add(new Course(courseId, courseName, creditHours));
            }
            return courses;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int addCourse(Course course) {
        int result = 0;
        sql = "insert into university.course (coursename,credit_hours) values(?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getCreditHours());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateCourse(Course course) {
        int result = 0;
        sql = "update university.course set courseName=?,credit_hours=? where courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getCreditHours());
            preparedStatement.setInt(3, course.getCourseId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int deleteCourse(Course course) {
        int result = 0;
        sql = "delete from university.course where courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, course.getCourseId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Course searchCourseById(Course course) {
        sql = "select * from university.course where courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, course.getCourseId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int courseId = resultSet.getInt("courseid");
                    String courseName = resultSet.getString("courseName");
                    int creditHours = resultSet.getInt("credit_hours");
                    return new Course(courseId, courseName, creditHours);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Course searchCourseByTitle(Course course) {
        sql = "select * from university.course where coursename like ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + course.getCourseName() + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int courseId = resultSet.getInt("courseid");
                    String courseName = resultSet.getString("courseName");
                    int creditHours = resultSet.getInt("credit_hours");
                    return new Course(courseId, courseName, creditHours);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countCourses() {
        int count = 0;
        sql = "select count(*) as 'total courses' from university.course";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}

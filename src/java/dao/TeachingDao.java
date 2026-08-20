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
import java.time.LocalDate;
import java.util.ArrayList;
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
            Logger.getLogger(TeachingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public ArrayList<Teaching> searchTeachingByProfessorId(Teaching teaching) {
        ArrayList<Teaching> teachingList = new ArrayList<>();
        sql = "select pc.professorid,pc.courseid,professorname,coursename,birthdate,specialization,phone,email from `professor-course`  pc join professor p on pc.professorid=p.professorid join course c on pc.courseid=c.courseid where pc.professorid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, teaching.getProfessor().getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int professorId = resultSet.getInt("professorid");
                    int courseid = resultSet.getInt("courseid");
                    String professorname = resultSet.getString("professorname");
                    String coursename = resultSet.getString("coursename");
                    LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
                    String specialization = resultSet.getString("specialization");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    Professor professor = new Professor(specialization, professorId, professorname, email, birthdate, phone);
                    Course course = new Course(courseid, coursename);
                    teachingList.add(new Teaching(professor, course));
                }
            }
            return teachingList;
        } catch (SQLException ex) {
            Logger.getLogger(TeachingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<Teaching> searchTeachingByCourseId(Teaching teaching) {
        ArrayList<Teaching> teachingList = new ArrayList<>();
        sql = "select pc.professorid,pc.courseid,professorname,coursename,birthdate,specialization,phone,email from `professor-course`  pc join professor p on pc.professorid=p.professorid join course c on pc.courseid=c.courseid where pc.courseid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, teaching.getCourse().getCourseId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int professorId = resultSet.getInt("professorid");
                    int courseid = resultSet.getInt("courseid");
                    String professorname = resultSet.getString("professorname");
                    String coursename = resultSet.getString("coursename");
                    LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
                    String specialzation = resultSet.getString("specialization");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    Professor professor = new Professor(specialzation, professorId, professorname, email, birthdate, phone);
                    Course course = new Course(courseid, coursename);
                    teachingList.add(new Teaching(professor, course));
                }
                return teachingList;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeachingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}

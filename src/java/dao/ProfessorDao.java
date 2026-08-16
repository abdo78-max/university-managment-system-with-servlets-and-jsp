/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import data.Course;
import data.Professor;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Compu City
 */
public class ProfessorDao {

    private Connection connection;
    private String sql;

    public ProfessorDao(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Professor> viewProfessors() {
        ArrayList<Professor> professors = new ArrayList<>();
        sql = "select * from university.professor";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int professorId = resultSet.getInt("professorid");
                String professorName = resultSet.getString("professorname");
                String specialization = resultSet.getString("specialization");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                LocalDate birthDate = resultSet.getDate("birthdate").toLocalDate();
                professors.add(new Professor(specialization, professorId, professorName, email, address, birthDate, phone));
            }
            return professors;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int addProfessor(Professor professor) {
        int result = 0;
        sql = "insert into university.professor (professorname,specialization,email,phone,address,birthdate)values(?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, professor.getName());
            preparedStatement.setString(2, professor.getSpecialization());
            preparedStatement.setString(3, professor.getEmail());
            preparedStatement.setString(4, professor.getPhone());
            preparedStatement.setString(5, professor.getAddress());
            preparedStatement.setDate(6, java.sql.Date.valueOf(professor.getBirthDate()));
            result = preparedStatement.executeUpdate();
            if (result == 1) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        professor.setId(resultSet.getInt(1));
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateProfessor(Professor professor) {
        int result = 0;
        sql = "update university.professor set professorname=?,specialization=?,email=?,phone=?,address=?,birthdate=? where professorid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, professor.getName());
            preparedStatement.setString(2, professor.getSpecialization());
            preparedStatement.setString(3, professor.getEmail());
            preparedStatement.setString(4, professor.getPhone());
            preparedStatement.setString(5, professor.getAddress());
            preparedStatement.setDate(6, java.sql.Date.valueOf(professor.getBirthDate()));
            preparedStatement.setInt(7, professor.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int deleteProfessor(Professor professor) {
        int result = 0;
        sql = "delete from university.professor where professorid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, professor.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Professor searchProfessorById(Professor professor) {
        sql = "select * from university.professor where professorid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, professor.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int professorId = resultSet.getInt("professorid");
                    String professorName = resultSet.getString("professorname");
                    String specialization = resultSet.getString("specialization");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String address = resultSet.getString("address");
                    LocalDate birthDate = resultSet.getDate("birthdate").toLocalDate();
                    return new Professor(specialization, professorId, professorName, email, address, birthDate, phone);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Professor> searchProfessorByName(Professor professor) {
        ArrayList<Professor> professors = new ArrayList<>();
        sql = "select * from university.professor where professorname like ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + professor.getName() + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int professorId = resultSet.getInt("professorid");
                    String professorName = resultSet.getString("professorname");
                    String specialization = resultSet.getString("specialization");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String address = resultSet.getString("address");
                    LocalDate birthDate = resultSet.getDate("birthdate").toLocalDate();
                    professors.add(new Professor(specialization, professorId, professorName, email, address, birthDate, phone));
                }
                return professors;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countProfessors() {
        int count = 0;
        sql = "select count(*) as 'total professors' from university.professor";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

     public Set<Course> getProfessorCourses(Professor professor) {
        Set<Course> courses = new HashSet<>();
        sql = "select c.courseid,coursename from course c join `professor-course` pc on c.courseid=pc.courseid where pc.professorid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, professor.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String courseName = resultSet.getString("coursename");
                    int courseId=resultSet.getInt("courseid");
                    courses.add(new Course(courseId,courseName));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return courses;
    }
}

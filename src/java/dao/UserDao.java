/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import data.Professor;
import data.Role;
import data.Student;
import data.User;
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
public class UserDao {

    private Connection connection;
    private String sql;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public UserDao() {
    }

    public User getUser(User user) {
        sql = "select username,password,role,studentid,professorid from university.users where username=? and password=?";
        try (PreparedStatement preparedStatment = connection.prepareStatement(sql)) {
            preparedStatment.setString(1, user.getUsername());
            preparedStatment.setString(2, user.getPassword());
            try (ResultSet resultSet = preparedStatment.executeQuery();) {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    int studentId = resultSet.getInt("studentid");
                    int professorId = resultSet.getInt("professorid");
                    Role role = Role.valueOf(resultSet.getString("role"));
                    if (studentId > 0) {
                        StudentDao studentDao = new StudentDao(connection);
                        Student student = new Student();
                        student.setId(studentId);
                        Student selectedStudent = studentDao.searchStudentById(student);
                        return new User(username, password, selectedStudent, role);
                    } else if (professorId > 0) {
                        ProfessorDao professorDao = new ProfessorDao(connection);
                        Professor professor = new Professor();
                        professor.setId(professorId);
                        Professor selectedProfessor = professorDao.searchProfessorById(professor);
                        return new User(username, password, selectedProfessor, role);
                    } else {
                        User admin = new User(username, password);
                        admin.setRole(role);
                        return admin;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public int addUser(User user) {
        int count = 0;
        sql = "insert into university.users (username,password,role,studentid,professorid)values(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole().toString());
            if (user.getStudent() != null) {
                preparedStatement.setInt(4, user.getStudent().getId());
            } else {
                preparedStatement.setNull(4, java.sql.Types.INTEGER);
            }
            if (user.getProfessor() != null) {
                preparedStatement.setInt(5, user.getProfessor().getId());
            } else {
                preparedStatement.setNull(5, java.sql.Types.INTEGER);
            }
            count = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int updateUser(User user) {
        int count = 0;
        sql = " update university.users set username=?,password=?,role=?,studentid=?,professorid=? where userid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole().toString());
            preparedStatement.setInt(4, user.getStudent().getId());
            preparedStatement.setInt(5, user.getProfessor().getId());
            preparedStatement.setInt(6, user.getUserId());
            count = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int deleteUser(User user) {
        int count = 0;
        sql = " delete from university.users where userid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getUserId());
            count = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int countUsers() {
        int count = 0;
        sql = "select count(*) as 'total users' from university.users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}

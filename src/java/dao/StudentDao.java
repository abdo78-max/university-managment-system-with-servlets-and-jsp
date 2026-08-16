/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import data.Course;
import data.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
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
public class StudentDao {

    private Connection connection;
    private String sql;

    public StudentDao(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Student> viewStudents() {
        ArrayList<Student> students = new ArrayList<>();
        sql = "select * from university.student";
        try (PreparedStatement preparedStatment = connection.prepareStatement(sql); ResultSet resultSet = preparedStatment.executeQuery();) {
            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentid");
                String studentName = resultSet.getString("studentname");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                LocalDate birthDate = resultSet.getDate("birthdate").toLocalDate();
                String phone = resultSet.getString("phone");
                students.add(new Student(studentId, studentName, email, address, birthDate, phone));
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int addStudent(Student student) {
        int result = 0;
        sql = "insert into university.student(studentname,email,address,birthdate,phone) values(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setDate(4, java.sql.Date.valueOf(student.getBirthDate()));
            preparedStatement.setString(5, student.getPhone());
            result = preparedStatement.executeUpdate();
            if (result == 1) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        student.setId(resultSet.getInt(1));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateStudent(Student student) {
        int result = 0;
        sql = "update university.student set studentname=?,email=?,address=?,birthdate=?,phone=? where studentid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setDate(4, java.sql.Date.valueOf(student.getBirthDate()));
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setInt(6, student.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int deleteStudent(Student student) {
        int result = 0;
        sql = "delete from university.student where studentid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, student.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Student searchStudentById(Student student) {
        sql = "select * from university.student where studentid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, student.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    int studentId = resultSet.getInt("studentid");
                    String studentName = resultSet.getString("studentname");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    LocalDate birthDate = resultSet.getDate("birthdate").toLocalDate();
                    String phone = resultSet.getString("phone");
                    return new Student(studentId, studentName, email, address, birthDate, phone);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Student> searchStudentByName(Student student) {
        ArrayList<Student> students = new ArrayList<>();
        sql = "select * from university.student where studentname like ?";
        try (PreparedStatement preparedStatment = connection.prepareStatement(sql);) {
            preparedStatment.setString(1, "%" + student.getName() + "%");
            try (ResultSet resultSet = preparedStatment.executeQuery();) {
                while (resultSet.next()) {
                    int studentId = resultSet.getInt("studentid");
                    String studentName = resultSet.getString("studentname");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    LocalDate birthDate = resultSet.getDate("birthdate").toLocalDate();
                    String phone = resultSet.getString("phone");
                    students.add(new Student(studentId, studentName, email, address, birthDate, phone));
                }
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countStudents() {
        int count = 0;
        sql = "select count(*) AS 'total students' from university.student";
        try (PreparedStatement preparedStatment = connection.prepareStatement(sql); ResultSet resultSet = preparedStatment.executeQuery();) {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public Set<Course> getStudentCourses(Student student) {
        Set<Course> courses = new HashSet<>();
        sql = "select c.courseid,coursename from course c join `student-course` sc on c.courseid=sc.courseid where sc.studentid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, student.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String courseName = resultSet.getString("coursename");
                    int courseId=resultSet.getInt("courseid");
                    courses.add(new Course(courseId,courseName));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return courses;
    }
}

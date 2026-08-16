/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Compu City
 */
public class User {

    private int userId;
    private String username;
    private String password;
    private Student student;
    private Professor professor;
    private Role role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(int userId, String username, String password, Student student, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.student = student;
        this.role = role;
    }

    public User(int userId, String username, String password, Professor professor, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.professor = professor;
        this.role = role;
    }

    public User(String username, String password, Professor professor, Role role) {
        this.username = username;
        this.password = password;
        this.professor = professor;
        this.role = role;
    }

    public User(String username, String password, Student student, Role role) {
        this.username = username;
        this.password = password;
        this.student = student;
        this.role = role;
    }

    public User(String username, String password, Student student) {
        this.username = username;
        this.password = password;
        this.student = student;
    }

    public User(String username, String password, Professor professor) {
        this.username = username;
        this.password = password;
        this.professor = professor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username=" + username + ", password=" + password + ", student=" + (student != null ? student.getId() : null) + ", professor=" + (professor != null ? professor.getId() : null) + ", role=" + role + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Compu City
 */
public class Teaching {
    private Professor professor;
    private Course course;

    public Teaching(Professor professor) {
        this.professor = professor;
    }

    public Teaching(Course course) {
        this.course = course;
    }

    public Teaching(Professor professor, Course course) {
        this.professor = professor;
        this.course = course;
    }

    public Teaching() {
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teaching{" + "professor=" + professor.getId() + ", course=" + course.getCourseId() + '}';
    }
    
}

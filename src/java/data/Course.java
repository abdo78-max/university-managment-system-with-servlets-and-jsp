/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Compu City
 */
public class Course {

    private int courseId;
    private String courseName;
    private int creditHours;
    

    public Course() {
    }

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Course(String courseName, int creditHours) {
        this.courseName = courseName;
        this.creditHours = creditHours;
    }


    public Course(String courseName) {
        this.courseName = courseName;
    }
    private Set<Professor> professors = new HashSet<>();
    private Set<Student> students = new HashSet<>();

    public Course(int courseId) {
        this.courseId = courseId;
    }

    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Course(int courseId, String courseName, int creditHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    @Override
    public String toString() {
        String profName = "";
        for (Professor professor : professors) {
            profName += "{" + professor.getName() + "," + professor.getId() + "}" + ", ";
        }
        String studentName = "";
        for (Student student : students) {
            studentName += "{" + student.getName() + ',' + student.getId() + "}" + ", ";
        }
        String afterFilteringProfName = "";
        if (!profName.isEmpty()) {
            afterFilteringProfName = profName.substring(0, profName.length() - 2);
        }
        String afterFilteringStudentName = "";
        if (!studentName.isEmpty()) {
            afterFilteringStudentName = studentName.substring(0, studentName.length() - 2);
        }
        return "Course{" + "courseId=" + courseId + ", courseName=" + courseName + ", creditHours=" + creditHours + ", professors=" + afterFilteringProfName + ", students=" + afterFilteringStudentName + '}';
    }

}

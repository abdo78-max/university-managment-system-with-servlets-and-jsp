/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Compu City
 */
public class Student extends Person {

    private Set<Course> courses = new HashSet<>();

    public Student() {
    }

    public Student(int id) {
        super(id);
    }

    public Student(String name) {
        super(name);
    }

    public Student(int id, String name) {
        super(id, name);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Student(int id, String name, String email, String address, LocalDate birthDate, String phone) {
        super(id, name, email, address, birthDate, phone);
    }

    public Student(String name, String email, String address, LocalDate birthDate, String phone) {
        super(name, email, address, birthDate, phone);
    }

    @Override
    public String toString() {
        String coursesName = "";
        for (Course course : courses) {
            coursesName += "{" + course.getCourseId() + ',' + course.getCourseName() + ',' + ',' + "}" + ", ";
        }
        String afterFilteringCoursesName = "";
        if (!coursesName.isEmpty()) {
            afterFilteringCoursesName = coursesName.substring(0, coursesName.length() - 2);
        }
        return super.toString() + "Student{" + "courses=" + afterFilteringCoursesName + '}';
    }

}

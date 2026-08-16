package data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Compu City
 */
public class Professor extends Person {

    private String specialization;
    private Set<Course> courses = new HashSet<>();

    public Professor(String specialization, int id, String name, String email, String address, LocalDate birthDate, String phone) {
        super(id, name, email, address, birthDate, phone);
        this.specialization = specialization;
    }

    public Professor(int id, String name) {
        super(id, name);
    }

    public Professor(String name) {
        super(name);
    }

    public Professor(String specialization, String name, String email, String address, LocalDate birthDate, String phone) {
        super(name, email, address, birthDate, phone);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Professor(String name, String email, String address, LocalDate birthDate, String phone) {
        super(name, email, address, birthDate, phone);
    }

    public Professor(int id) {
        super(id);
    }

    public Professor() {
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
        return super.toString() + "Professor{" + "specialzation=" + specialization + ", courses=" + afterFilteringCoursesName + '}';
    }

}

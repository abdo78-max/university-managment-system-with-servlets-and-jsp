/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.time.LocalDate;

/**
 *
 * @author Compu City
 */
public abstract class Person {

    private int id;
    private String name;
    private String email;
    private String address;
    private LocalDate birthDate;
    private String phone;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name, String email, String address, LocalDate birthDate, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public Person(String name, String email, String address, LocalDate birthDate, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", birthDate=" + birthDate + ", phone=" + phone + '}';
    }

}

package com.softtechi.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id",nullable = false, updatable = false)
    private Long id;

    @Column(name = "first_name",nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "last_name",nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email",nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "phone",nullable = true)
    private String phone;

    @Column(name = "employee_code",nullable = false, updatable = false,columnDefinition = "TEXT")
    private String employeeCode;

    @Column(name = "image",nullable = true, columnDefinition = "TEXT")
    private String imageUrl;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployeeCode() {
        return this.employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    /*public Employee(Long id, String firstName, String lastName, String email, String phone, String employeeCode, String imageUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.employeeCode = employeeCode;
        this.imageUrl = imageUrl;
    }*/   

    public Employee() {
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", firstName='" + firstName + "'" +
            ", lastName='" + lastName + "'" +
            ", email='" + email + "'" +
            ", phone='" + phone + "'" +
            ", employeeCode='" + employeeCode + "'" +
            ", imageUrl='" + imageUrl + "'" +
            "}";
    }
    
}
package com.luv2code.springboot.crud_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // The length property set the length of the text in the column
    @Column(name = "first_name", length = 45)
    private String firstName;
    @Column(name = "last_name", length = 45)
    private String lastName;
    @Column(name = "email", length = 45)
    private String email;

    public Student() { }

    public Student(Long id, String firstName, String lastName, String email)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

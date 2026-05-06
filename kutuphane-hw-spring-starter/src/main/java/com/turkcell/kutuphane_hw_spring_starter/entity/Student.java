package com.turkcell.kutuphane_hw_spring_starter.entity;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;

@Entity
@Table(name = "ogrenciler")
public class Student {
    @Id
    @UuidGenerator
    @Column(name="ogrenci_id")
    private UUID id;

    @Column(name="ogrenci_adi", nullable = false)
    private String firstName;

    @Column(name="ogrenci_soyadi", nullable = false)
    private String lastName;

    @Column(name="ogrenci_bolum")
    private String department;

    @Column(name="ogrenci_tel")
    private String phone;

    @Column(name="ogrenci_email")
    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
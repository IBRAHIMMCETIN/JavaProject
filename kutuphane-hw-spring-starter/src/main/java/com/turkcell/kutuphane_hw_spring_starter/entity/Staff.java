package com.turkcell.kutuphane_hw_spring_starter.entity;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;

@Entity
@Table(name = "gorevliler")
public class Staff {
    @Id
    @UuidGenerator
    @Column(name="gorevli_id")
    private UUID id;

    @Column(name="gorevli_adi", nullable = false)
    private String firstName;

    @Column(name="gorevli_soyadi", nullable = false)
    private String lastName;

    @Column(name="gorevli_email")
    private String email;

    @Column(name="gorevli_tel")
    private String phone;

    @Column(name="sifre", nullable = false)
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
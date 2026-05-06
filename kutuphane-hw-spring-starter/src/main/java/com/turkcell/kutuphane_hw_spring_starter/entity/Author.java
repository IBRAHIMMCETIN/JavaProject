package com.turkcell.kutuphane_hw_spring_starter.entity;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;

@Entity
@Table(name = "yazarlar")
public class Author {
    @Id
    @UuidGenerator
    @Column(name="yazar_id")
    private UUID id;

    @Column(name="yazar_adi", nullable = false)
    private String firstName;

    @Column(name="yazar_soyadi", nullable = false)
    private String lastName;

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

    
}
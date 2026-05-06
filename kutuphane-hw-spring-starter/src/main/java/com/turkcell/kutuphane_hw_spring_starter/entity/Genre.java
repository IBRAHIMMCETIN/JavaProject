package com.turkcell.kutuphane_hw_spring_starter.entity;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;

@Entity
@Table(name = "turler")
public class Genre {
    @Id
    @UuidGenerator
    @Column(name="tur_id")
    private UUID id;

    @Column(name="tur_adi", nullable = false)
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
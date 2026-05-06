package com.turkcell.kutuphane_hw_spring_starter.entity;

import java.util.UUID;
import java.time.LocalDate;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;

@Entity
@Table(name = "iade")
public class ReturnRecord {
    @Id
    @UuidGenerator
    @Column(name="iade_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "odunc_id", nullable = false)
    private Borrow borrow;

    @Column(name="iade_tarihi", nullable = false)
    private LocalDate returnDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

}
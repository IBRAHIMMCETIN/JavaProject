package com.turkcell.kutuphane_hw_spring_starter.entity;

import java.util.UUID;
import java.time.LocalDate;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;

@Entity
@Table(name = "odunc")
public class Borrow {
    @Id
    @UuidGenerator
    @Column(name="odunc_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "kitap_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "ogrenci_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "gorevli_id", nullable = false)
    private Staff staff;

    @Column(name="alinan_tarih", nullable = false)
    private LocalDate borrowDate;

    @Column(name="son_teslim_tarihi")
    private LocalDate dueDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

}
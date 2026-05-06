package com.turkcell.kutuphane_hw_spring_starter.dto;
import java.util.UUID;
import java.time.LocalDate;
public class ListBorrowResponse {
    private UUID id;
    private String bookName;
    private String studentName;
    private String staffName;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
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
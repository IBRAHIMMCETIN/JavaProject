package com.turkcell.kutuphane_hw_spring_starter.dto;
import java.util.UUID;
import java.time.LocalDate;
public class ListReturnResponse {
    private UUID id;
    private String bookName;
    private String studentName;
    private LocalDate borrowDueDate;
    private LocalDate returnDate;
    private String penaltyStatus;
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
    public LocalDate getBorrowDueDate() {
        return borrowDueDate;
    }
    public void setBorrowDueDate(LocalDate borrowDueDate) {
        this.borrowDueDate = borrowDueDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public String getPenaltyStatus() {
        return penaltyStatus;
    }
    public void setPenaltyStatus(String penaltyStatus) {
        this.penaltyStatus = penaltyStatus;
    }
}
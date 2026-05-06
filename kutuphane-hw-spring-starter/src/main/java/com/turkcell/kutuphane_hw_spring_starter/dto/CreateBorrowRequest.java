package com.turkcell.kutuphane_hw_spring_starter.dto;
import java.util.UUID;
import java.time.LocalDate;
public class CreateBorrowRequest {
    private UUID bookId;
    private UUID studentId;
    private UUID staffId;
    private LocalDate dueDate;
    public UUID getBookId() {
        return bookId;
    }
    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }
    public UUID getStudentId() {
        return studentId;
    }
    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }
    public UUID getStaffId() {
        return staffId;
    }
    public void setStaffId(UUID staffId) {
        this.staffId = staffId;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
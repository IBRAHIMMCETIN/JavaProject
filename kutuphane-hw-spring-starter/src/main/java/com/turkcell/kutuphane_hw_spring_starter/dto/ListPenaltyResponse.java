package com.turkcell.kutuphane_hw_spring_starter.dto;
import java.util.UUID;
import java.math.BigDecimal;
public class ListPenaltyResponse {
    private UUID id;
    private String studentName;
    private String bookName;
    private BigDecimal amount;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    
}
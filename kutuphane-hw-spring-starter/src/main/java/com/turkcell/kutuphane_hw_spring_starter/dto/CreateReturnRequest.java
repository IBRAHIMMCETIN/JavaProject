package com.turkcell.kutuphane_hw_spring_starter.dto;
import java.util.UUID;
public class CreateReturnRequest {
    private UUID borrowId;

    public UUID getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(UUID borrowId) {
        this.borrowId = borrowId;
    }
}
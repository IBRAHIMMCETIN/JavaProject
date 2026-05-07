package com.turkcell.kutuphane_spring_cqrs.application.features.loan.command.create;

import java.time.LocalDate;
import java.util.UUID;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.Command;

public record CreateLoanCommand(
    UUID bookId, 
    UUID studentId, 
    UUID staffId, 
    LocalDate borrowDate, 
    LocalDate dueDate
) implements Command<UUID> {
}
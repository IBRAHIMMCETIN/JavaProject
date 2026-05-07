package com.turkcell.kutuphane_spring_cqrs.application.features.returnaction.command.create;

import java.time.LocalDate;
import java.util.UUID;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.Command;

public record CreateReturnCommand(
    UUID loanId, 
    LocalDate returnDate
) implements Command<UUID> {
}
package com.turkcell.kutuphane_spring_cqrs.application.features.student.command.create;

import java.util.UUID;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.Command;

public record CreateStudentCommand(
    String firstName, 
    String lastName, 
    String department, 
    String phone, 
    String email
) implements Command<UUID> {
}
package com.turkcell.kutuphane_spring_cqrs.application.features.staff.command.create;

import java.util.UUID;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.Command;

public record CreateStaffCommand(
    String firstName, 
    String lastName, 
    String email, 
    String phone, 
    String password
) implements Command<UUID> {
}CreateStaffCommandHandler
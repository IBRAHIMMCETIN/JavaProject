package com.turkcell.kutuphane_spring_cqrs.application.features.author.command.create;

import java.util.UUID;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.Command;

public record CreateAuthorCommand(
    String firstName, 
    String lastName
) implements Command<UUID> {
}
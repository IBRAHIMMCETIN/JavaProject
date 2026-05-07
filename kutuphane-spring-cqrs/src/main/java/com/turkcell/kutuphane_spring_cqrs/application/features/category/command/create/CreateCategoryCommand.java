package com.turkcell.kutuphane_spring_cqrs.application.features.category.command.create;

import java.util.UUID;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.Command;

public record CreateCategoryCommand(
    String name
) implements Command<UUID> {
}
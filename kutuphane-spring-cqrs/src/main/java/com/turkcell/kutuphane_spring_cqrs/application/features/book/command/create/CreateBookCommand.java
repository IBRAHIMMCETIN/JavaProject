package com.turkcell.kutuphane_spring_cqrs.application.features.book.command.create;

import java.util.UUID;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.Command;

public record CreateBookCommand(
    String isbn, 
    String name, 
    Integer releaseYear, 
    UUID categoryId, 
    UUID authorId
) implements Command<UUID> {
}
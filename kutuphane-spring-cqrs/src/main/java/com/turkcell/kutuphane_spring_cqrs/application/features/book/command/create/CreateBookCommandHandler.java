package com.turkcell.kutuphane_spring_cqrs.application.features.book.command.create;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class CreateBookCommandHandler implements CommandHandler<CreateBookCommand, UUID> {
    @Override
    public UUID handle(CreateBookCommand command) {
        System.out.println("Kitap eklendi: " + command.name());
        return UUID.randomUUID();
    }
}
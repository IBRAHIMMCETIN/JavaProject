package com.turkcell.kutuphane_spring_cqrs.application.features.student.command.create;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class CreateStudentCommandHandler implements CommandHandler<CreateStudentCommand, UUID> {
    @Override
    public UUID handle(CreateStudentCommand command) {
        System.out.println("Öğrenci eklendi: " + command.firstName() + " " + command.lastName());
        return UUID.randomUUID();
    }
}
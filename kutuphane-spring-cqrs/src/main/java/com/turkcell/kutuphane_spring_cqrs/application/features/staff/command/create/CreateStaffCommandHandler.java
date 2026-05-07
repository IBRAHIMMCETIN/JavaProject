package com.turkcell.kutuphane_spring_cqrs.application.features.staff.command.create;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class CreateStaffCommandHandler implements CommandHandler<CreateStaffCommand, UUID> {
    @Override
    public UUID handle(CreateStaffCommand command) {
        System.out.println("Görevli eklendi: " + command.firstName() + " " + command.lastName());
        return UUID.randomUUID();
    }
}
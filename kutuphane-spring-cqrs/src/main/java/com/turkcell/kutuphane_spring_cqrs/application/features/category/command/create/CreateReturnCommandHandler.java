package com.turkcell.kutuphane_spring_cqrs.application.features.returnaction.command.create;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class CreateReturnCommandHandler implements CommandHandler<CreateReturnCommand, UUID> {
    @Override
    public UUID handle(CreateReturnCommand command) {
        System.out.println("İade işlemi kaydedildi. Ödünç ID: " + command.loanId());
        return UUID.randomUUID();
    }
}
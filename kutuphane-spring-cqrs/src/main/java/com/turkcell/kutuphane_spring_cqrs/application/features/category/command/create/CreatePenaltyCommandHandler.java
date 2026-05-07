package com.turkcell.kutuphane_spring_cqrs.application.features.penalty.command.create;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class CreatePenaltyCommandHandler implements CommandHandler<CreatePenaltyCommand, UUID> {
    @Override
    public UUID handle(CreatePenaltyCommand command) {
        System.out.println("Ceza kaydedildi. Tutar: " + command.penaltyAmount());
        return UUID.randomUUID();
    }
}
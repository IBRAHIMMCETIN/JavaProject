package com.turkcell.kutuphane_spring_cqrs.application.features.loan.command.create;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class CreateLoanCommandHandler implements CommandHandler<CreateLoanCommand, UUID> {
    @Override
    public UUID handle(CreateLoanCommand command) {
        System.out.println("Ödünç kaydı oluşturuldu. Kitap ID: " + command.bookId());
        return UUID.randomUUID();
    }
}
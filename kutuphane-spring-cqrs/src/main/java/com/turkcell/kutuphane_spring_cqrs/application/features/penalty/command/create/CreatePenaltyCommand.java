package com.turkcell.kutuphane_spring_cqrs.application.features.penalty.command.create;

import java.math.BigDecimal;
import java.util.UUID;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.Command;

public record CreatePenaltyCommand(
    UUID returnId, 
    BigDecimal penaltyAmount
) implements Command<UUID> {
}
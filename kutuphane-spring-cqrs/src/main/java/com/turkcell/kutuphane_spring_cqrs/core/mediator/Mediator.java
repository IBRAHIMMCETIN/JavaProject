package com.turkcell.kutuphane_spring_cqrs.core.mediator;

import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.Command;
import com.turkcell.kutuphane_spring_cqrs.core.mediator.cqrs.Query;

public interface Mediator {
    <R> R send(Command<R> command);
    <R> R send(Query<R> query);
}
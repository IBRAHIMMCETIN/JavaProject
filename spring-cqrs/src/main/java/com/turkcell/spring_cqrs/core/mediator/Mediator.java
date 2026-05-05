package com.turkcell.spring_cqrs.core.mediator;

import com.turkcell.spring_cqrs.core.mediator.cqrs.Query;
import com.turkcell.spring_cqrs.core.mediator.cqrs.Command;

public interface Mediator {
    
    <R> R send(Command<R> command);
    <R> R send(Query<R> query);

}

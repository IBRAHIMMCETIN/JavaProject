package com.turkcell.spring_cqrs.core.mediator.pipeline;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public interface PipelineBehavior {
    <R> R handle(Object request, RequestHandlerDelegate<R> next);

    default boolean supports(Object request) {
        return true; 
    }
}
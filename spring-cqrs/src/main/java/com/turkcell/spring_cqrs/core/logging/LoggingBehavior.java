package com.turkcell.spring_cqrs.core.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.spring_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(2)
public class LoggingBehavior implements PipelineBehavior {

    private static final Logger logger = LoggerFactory.getLogger(LoggingBehavior.class);

    @Override
    public boolean supports(Object request) {
        return request instanceof LoggableRequest;
    }
    
    
    //YAPAY ZEKA İLE YAPTIM
    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        String requestTypeName = request.getClass().getSimpleName();

        logger.info("[REQUEST] İşlem: {} | Gelen Veri: {}", requestTypeName, request);

        R response = next.invoke();

        logger.info("[RESPONSE] İşlem: {} | Dönen Cevap: {}", requestTypeName, response);

        return response;
    }
}
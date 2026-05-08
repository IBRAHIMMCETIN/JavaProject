package com.turkcell.spring_cqrs.core.mediator.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0) 
public class PerformanceBehavior implements PipelineBehavior {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceBehavior.class);
    private static final long THRESHOLD_MS = 3000;

    @Override
    public boolean supports(Object request) {
        
        return true; 
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        long start = System.currentTimeMillis();

        
        R result = next.invoke();

        long elapsed = System.currentTimeMillis() - start;

        if (elapsed > THRESHOLD_MS) {
            String requestName = request.getClass().getSimpleName();
            logger.warn("[PERFORMANS UYARISI] {} işlemi çok yavaş! Sürdüğü zaman: {} ms.", requestName, elapsed);
        }

        return result;
    }
}
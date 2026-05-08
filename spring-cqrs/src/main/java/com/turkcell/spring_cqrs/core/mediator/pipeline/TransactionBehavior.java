package com.turkcell.spring_cqrs.core.mediator.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.turkcell.spring_cqrs.core.mediator.cqrs.Command; // Command arayüzünü import ettik

@Component
@Order(3) 
public class TransactionBehavior implements PipelineBehavior {

    private static final Logger logger = LoggerFactory.getLogger(TransactionBehavior.class);
    private final PlatformTransactionManager transactionManager;

    
    public TransactionBehavior(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public boolean supports(Object request) {
        
        return request instanceof Command;
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        String requestName = request.getClass().getSimpleName();
        logger.info("[TRANSACTION BAŞLADI] {}", requestName);

        
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            
            R result = next.invoke();
            
            
            transactionManager.commit(status);
            logger.info("[TRANSACTION BAŞARILI] {} - Commit edildi.", requestName);
            
            return result;
        } catch (Exception ex) {
            
            transactionManager.rollback(status);
            logger.error("[TRANSACTION İPTAL] {} - Hata: {}. Rollback yapıldı!", requestName, ex.getMessage());
            throw ex; 
        }
    }
}
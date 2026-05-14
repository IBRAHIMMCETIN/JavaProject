package com.turkcell.spring_cqrs.core.security.authorization;

import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.spring_cqrs.core.mediator.pipeline.RequestHandlerDelegate;
import com.turkcell.spring_cqrs.core.security.context.UserContext;
import com.turkcell.spring_cqrs.core.security.exception.AuthorizationException;

@Component
@Order(10)
public class AuthorizationBehavior implements PipelineBehavior {
    private final UserContext userContext;

    public AuthorizationBehavior(UserContext userContext) {
        this.userContext = userContext;
    }

    @Override
    public boolean supports(Object request) {
        return request instanceof AuthorizableRequest;
    }

    // ilgili handler'ın öncesi ve sonrası çalıştırabilen kodlar.
    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        if(!userContext.isAuthenticated())
            throw new RuntimeException("Giriş yapmalısın..");

        AuthorizableRequest authorizableRequest = (AuthorizableRequest) request;
        List<String> requiredRoles = authorizableRequest.getRequiredRoles();

        if (!requiredRoles.isEmpty()) {
            boolean hasRequiredRole = userContext.getRoles().stream()
                    .anyMatch(requiredRoles::contains);

            if (!hasRequiredRole) {
                throw new AuthorizationException("Gerekli yetkiye sahip değilsin!");
            }
        }
        
        return next.invoke(); // zincirdeki sonraki halkayı çağır..
    }

}
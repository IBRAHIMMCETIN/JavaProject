package com.turkcell.spring_cqrs.core.security.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.turkcell.spring_cqrs.core.security.context.UserContext;
import com.turkcell.spring_cqrs.core.security.jwt.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    
    private final JwtService jwtService;
    private final UserContext userContext;
    
    public JwtAuthFilter(JwtService jwtService, UserContext userContext) {
        this.jwtService = jwtService;
        this.userContext = userContext;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String jwtHeader = request.getHeader("Authorization");

        if (jwtHeader != null){
            String token = jwtHeader.substring(7);
            try {
                if (jwtService.isTokenValid(token)){
                    String userId = jwtService.extractUserId(token);
                    String email = jwtService.extractEmail(token);
                    List<String> roles = Collections.EMPTY_LIST;
                    

                    userContext.setUserId(userId, email, roles);
                }
            } catch (Exception e) {
                //SecurityContextHolder.clearContext();
            }
        }

        filterChain.doFilter(request, response);
    }


    

}

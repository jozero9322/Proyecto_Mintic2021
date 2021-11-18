package com.ecoturismo.ecoturismoapi.utils;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

@Component
public class Autorizacion implements Filter{
    public static final String key = "cualquierValor";

    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)  throws IOException, ServletException{

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        if (url.contains("api/clientes/login")){
            System.out.println("Estoy accediendo a la ruta de clientes");
            chain.doFilter(request, response);
        } else {
            String token = httpServletRequest.getHeader("token");
            if(token == null || token.trim().equals("")){
                response.setContentType("application/json");
                String body = "{\"Autorizacion\":\" No tienes Autorizacion \"}";
                response.getWriter().write(body);
            }
            try {
                Jwts.parser().setSigningKey(key).parseClaimsJws(token);
                chain.doFilter(request, response);
                
            } 
            catch(MalformedJwtException e){
                response.setContentType("application/json");
                String body = "{\"Autorizacion\":\" Token Invalido \"}";
                response.getWriter().write(body);
            }
            catch(SignatureException e){
                response.setContentType("application/json");
                String body = "{\"Autorizacion\":\" La Key es incorrecta \"}";
                response.getWriter().write(body);
            }
            catch(ExpiredJwtException e){
                response.setContentType("application/json");
                String body = "{\"Autorizacion\":\" El token ya expiró \"}";
                response.getWriter().write(body);
            }
            catch (Exception e) {
                response.setContentType("application/json");
                String body = "{\"Autorizacion\":\" No tienes Autorizacion \"}";
                response.getWriter().write(body);
            }
            
        }

    }
}

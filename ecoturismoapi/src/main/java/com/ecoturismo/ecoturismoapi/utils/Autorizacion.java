package com.ecoturismo.ecoturismoapi.utils;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Component;

@Component
public class Autorizacion implements Filter{
    public static final String key = "cualquierValor";

    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)  throws IOException, ServletException{

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        System.out.println(url);
        
    }
}

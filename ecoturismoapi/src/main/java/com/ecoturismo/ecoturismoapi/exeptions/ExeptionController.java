package com.ecoturismo.ecoturismoapi.exeptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExeptionController {
    
    @ExceptionHandler(CustomExeption.class)
    public Mensaje ErrorExeption(CustomExeption exeption){
        return new Mensaje("CustomExeption", exeption.getMessage());
    }
}

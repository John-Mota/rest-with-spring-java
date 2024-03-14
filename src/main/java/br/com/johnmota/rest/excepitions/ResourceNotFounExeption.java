package br.com.johnmota.rest.excepitions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFounExeption extends RuntimeException{

    private static final long serialVersionUID = 1l;
    
    public ResourceNotFounExeption(String message) {
        super(message);
    }
    
}

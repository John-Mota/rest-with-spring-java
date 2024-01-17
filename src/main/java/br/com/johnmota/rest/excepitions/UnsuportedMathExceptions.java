package br.com.johnmota.rest.excepitions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathExceptions extends RuntimeException{

    public UnsuportedMathExceptions(String message) {
        super(message);
    }
    private static final long serialVersionUID = 1l;

}

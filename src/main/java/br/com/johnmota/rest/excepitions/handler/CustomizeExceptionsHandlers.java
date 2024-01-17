package br.com.johnmota.rest.excepitions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.johnmota.rest.excepitions.ExcepitionsResponse;
import br.com.johnmota.rest.excepitions.UnsuportedMathExceptions;

@ControllerAdvice
@RestController
public class CustomizeExceptionsHandlers extends ResponseEntityExceptionHandler{

  @ExceptionHandler(UnsuportedMathExceptions.class)
  public final ResponseEntity<ExcepitionsResponse> handleBadRequestExceptions(Exception ex, WebRequest request){
    ExcepitionsResponse ExcepitionsResponse = new ExcepitionsResponse(
      new Date(), 
     ex.getMessage(), 
     request.getDescription(false));
    return new ResponseEntity<>(ExcepitionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExcepitionsResponse> handleAllExceptions(Exception ex, WebRequest request){
    ExcepitionsResponse ExcepitionsResponse = new ExcepitionsResponse(
      new Date(), 
     ex.getMessage(), 
     request.getDescription(false));
    return new ResponseEntity<>(ExcepitionsResponse, HttpStatus.BAD_REQUEST);
  }
  
}

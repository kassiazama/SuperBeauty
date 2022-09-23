package br.com.unicv.superbeauty.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardErrorResponse> notFound (NotFoundException exception, HttpServletRequest request){
        StandardErrorResponse error = new StandardErrorResponse();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Not Found");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NotAcceptableException.class)
    public ResponseEntity<StandardErrorResponse> notAcceptable (NotAcceptableException exception, HttpServletRequest request){
        StandardErrorResponse error = new StandardErrorResponse();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        error.setError("Not Acceptable");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErrorResponse> notAcceptable (MethodArgumentNotValidException exception, HttpServletRequest request){
         
        if (exception.getFieldError() == exception.getFieldError("email")){
            StandardErrorResponse error = new StandardErrorResponse();
            error.setTimestamp(Instant.now());
            error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
            error.setError("Not Acceptable");
            error.setMessage("Email não é valido");
            error.setPath(request.getRequestURI());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
        } else {
            StandardErrorResponse error = new StandardErrorResponse();
            error.setTimestamp(Instant.now());
            error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
            error.setError("Not Acceptable");
            error.setMessage("Por favor, confira todos os campos");
            error.setPath(request.getRequestURI());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
        }
    }
}


    

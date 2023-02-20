package com.kaio.helpdesk.resources.excepetions;

import com.kaio.helpdesk.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException ex,
                                                                 HttpServletRequest request) {
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                "Object Not Found!", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandartError> objectNotFoundException(DataIntegrityViolationException ex,
                                                                 HttpServletRequest request) {
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Violação de dados!", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}

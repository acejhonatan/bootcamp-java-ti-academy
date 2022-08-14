package com.acejhonatan.parkingcontrol.api.exception.handler;

import com.acejhonatan.parkingcontrol.domain.service.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NotNull MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Error.Field> fields = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) error).getField();
            String message = ((FieldError) error).getDefaultMessage();
            fields.add(new Error.Field(name, message));
        }

        Error error = new Error();
        error.setStatus(status.value());
        error.setTitle("One or more fields are invalid. Please fill in correctly and try again.");
        error.setFields(fields);

        return handleExceptionInternal(ex, error, headers, status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        return handleException(ex, new Error(), NOT_FOUND, request);
    }

    @ExceptionHandler(EntityExistsException.class)
    private ResponseEntity<Object> handleEntityExits(EntityExistsException ex, WebRequest request) {
        return handleException(ex, new Error(), BAD_REQUEST, request);
    }

    private ResponseEntity<Object> handleException(Exception ex, Error error, HttpStatus status, WebRequest request) {
        error.setStatus(status.value());
        error.setTitle(ex.getMessage());
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }
}

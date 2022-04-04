package com.praveen.associations.controller.exception.handler;

import com.praveen.associations.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RequestErrorHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, String> handleError(final MethodArgumentNotValidException exception) {

    final var errors = new HashMap<String, String>();

    final var fieldErrors = exception.getBindingResult().getFieldErrors();
    fieldErrors.forEach(
        fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));

    return errors;
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleError(final NotFoundException exception) {

    return exception.getMessage();
  }
}

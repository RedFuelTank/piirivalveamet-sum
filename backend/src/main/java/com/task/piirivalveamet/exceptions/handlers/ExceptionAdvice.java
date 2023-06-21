package com.task.piirivalveamet.exceptions.handlers;

import com.task.piirivalveamet.exceptions.validation.ValidationErrorsList;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponseEntity validate(ConstraintViolationException exception) {
    return new ErrorResponseEntity(
      exception.getClass().getSimpleName(),
      exception.getMessage()
    );
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ValidationErrorsList validate(MethodArgumentNotValidException exception) {
    var fields = exception.getBindingResult().getFieldErrors();
    ValidationErrorsList validationErrors = new ValidationErrorsList();

    fields.forEach(validationErrors::addFieldError);

    return validationErrors;
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String validate(Exception exception) {
    return "internal error!";
  }
}

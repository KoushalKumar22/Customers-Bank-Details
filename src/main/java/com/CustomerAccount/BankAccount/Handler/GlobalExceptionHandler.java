package com.CustomerAccount.BankAccount.Handler;

import com.CustomerAccount.BankAccount.Exceptions.AccountNotFoundException;
import com.CustomerAccount.BankAccount.Exceptions.IdNotFoundException;
import com.CustomerAccount.BankAccount.Exceptions.NameNotFoundException;
import org.apache.coyote.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,String> errors=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName=((FieldError)error).getField();
            String errorMessage=error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationError(DataIntegrityViolationException exception,WebRequest request){
        String errorMessage="WrongInput";
        Throwable cause=exception.getCause();
        if (cause instanceof ConstraintViolationException){
            ConstraintViolationException constraintViolation=(ConstraintViolationException) cause;
            String constraintName=constraintViolation.getConstraintName();

            if (constraintName!= null){
                switch (constraintName){
                    case "unique_phone":
                        errorMessage="Phone No Already Registered!";
                        break;
                    case "unique_accNo":
                        errorMessage="Account Number Already Registered!";
                        break;
                    case "fk_customer":
                        errorMessage = "Referenced customer does not exist.";
                        break;
                    default:
                        errorMessage = "A constraint was violated. Please check your input.";
                        break;
                }
            }
        }
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<Object> handleNameNotFoundException(NameNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
}

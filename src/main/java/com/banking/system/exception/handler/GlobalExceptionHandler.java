package com.banking.system.exception.handler;

import com.banking.system.dto.ApiErrorResponse;
import com.banking.system.dto.ApiSubError;
import com.banking.system.exception.NotFoundException;
import com.banking.system.exception.AlreadyExistException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setStatus("400 NOT_FOUND");
        apiErrorResponse.setTimestamp(LocalDateTime.now());
        if(ex.getBindingResult().hasErrors()){
            List<ApiSubError> subErrors = ex.getBindingResult().getFieldErrors().stream().
                    map(error -> new ApiSubError(
                            "Customer",
                            error.getField(), (String) error.getRejectedValue(),error.getDefaultMessage())).collect(Collectors.toList());
            apiErrorResponse.setSubErrors(subErrors);
        }
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiErrorResponse> handleMobileNumberAlreadyExist(AlreadyExistException ex){
        ApiErrorResponse errorResponse=new ApiErrorResponse();
        errorResponse.setStatus("409 CONFLICT");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiErrorResponse> handleAccountNotFound(NotFoundException ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setStatus("409 NOT_FOUND");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

}

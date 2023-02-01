package com.bankApp.authentication.utils.exemptions;

import com.bankApp.authentication.utils.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;

import static java.lang.String.valueOf;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(GeneralExceptions.class)
    public ResponseEntity<ErrorResponseDTO> GeneralExceptionHandler(HttpServletRequest httpServletRequest, GeneralExceptions ex){

        log.error("Error from {} is {} ",httpServletRequest.getRequestURI(),ex.getResponseMessage());

        return ResponseEntity.status((ex.getHttpStatus() == null) ? HttpStatus.INTERNAL_SERVER_ERROR :
                ex.getHttpStatus()).body((ex.getMessage() == null) ? (new ErrorResponseDTO("99","Internal server error",HttpStatus.INTERNAL_SERVER_ERROR)):
                (new ErrorResponseDTO(ex.getResponseCode(), ex.getMessage(),ex.getHttpStatus())));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ErrorResponseDTO SQLIntegrityConstraintViolationException(HttpServletRequest httpServletRequest, SQLIntegrityConstraintViolationException ex){

        log.error("Error from {} is {} ",httpServletRequest.getRequestURI(),ex.getMessage());

        if (ex.getMessage().contains("Duplicate entry")){
            String[] words = ex.getMessage().split("for");
            return new ErrorResponseDTO("80",words[0], HttpStatus.MULTIPLE_CHOICES);
        }
        return new ErrorResponseDTO("80",ex.getMessage(), HttpStatus.MULTIPLE_CHOICES);
    }
}

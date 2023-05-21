package com.bankApp.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class ErrorResponseDTO {
    private String code;
    private String message;
    private HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private String timestamp;

    public ErrorResponseDTO(String code, String message, HttpStatus httpStatus, String timestamp) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public ErrorResponseDTO(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }


    public ErrorResponseDTO(int errorCode, String message, HttpStatus httpStatus) {
    }

    public ErrorResponseDTO(int errorCode) {
    }
}

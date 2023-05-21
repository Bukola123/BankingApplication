package com.bankApp.utils.exemptions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class GeneralExceptions extends RuntimeException{
    private String responseCode;
    private String responseMessage;
    private HttpStatus httpStatus;

    public GeneralExceptions(String code, String message, HttpStatus status) {
        super(message);
        this.responseCode = code;
        this.responseMessage = message;
        this.httpStatus = status;
    }

//    public GeneralExceptions(ResponseEnum code, String message, HttpStatus status) {
//        super(message);
//        this.responseCode = code;
//        this.responseMessage = message;
//        this.httpStatus = status;
//    }
}

package com.bankApp.admin.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {
    private String responseCode;
    private String responseMessage;
    private Object data;
    private HttpStatus status;

}

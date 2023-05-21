//package com.bankApp.utils;
//
//import com.bankApp.utils.exemptions.GeneralExceptions;
//import com.bankApp.utils.general.enums.ResponseCodes;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class JsonUtils {
//
//    public <T> String stringifyObject(T object){
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.writeValueAsString(object);
//        }catch (Exception e){
//            log.error(e.getMessage(), e);
//            throw new GeneralExceptions(ResponseCodes.BAD_DATA, "Couldn't encrypt request", HttpStatus.BAD_REQUEST);
//        }
//
//    }
//    public <T> String encryptObjectToString(T object){
//        //Stringfy object
//
//        stringifyObject(object);
//        //Use key to encrypt the text
//
//    }
//}

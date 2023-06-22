package com.bankApp.utils.general.enums;

public enum ResponseCodes {

    CONFIG_NOT_FOUND("E05", "Participant Configuration not found"),
    INVALID_SEND_AMOUNT("E07", "Invalid Send Amount"),
    TRANSACTION_NOT_FOUND("E02", "Transaction not found"),
    INSUFFICIENT_BALANCE("E01", "Insufficient Balance"),
    INTERNAL_SERVER_ERROR("E03", "An Error occurred while processing request"),
    INVALID_REQUEST("E04", "An Error occurred while processing requests"),
    BAD_DATA("E1", "BAD REQUEST"),
    Success("000", "Successful"),
    Failed("999", "Failed");


    private String code;
    private String message;

    ResponseCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package com.bankApp.utils.general.interfaces;

public interface Adapter<T,U> {

    U handleRequest(T request) throws Exception;
}

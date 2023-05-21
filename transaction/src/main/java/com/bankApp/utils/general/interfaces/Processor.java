package com.bankApp.utils.general.interfaces;

public interface Processor<T,U> {
    U process(T request);
}

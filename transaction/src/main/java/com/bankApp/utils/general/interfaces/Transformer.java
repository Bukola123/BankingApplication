package com.bankApp.utils.general.interfaces;

public interface Transformer<T, U> {

    U transform(T request);
}

package com.bankApp.authentication.utils;

public class Utils {


    public static String generateRandomNo(int max){

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < max; i++){
            stringBuilder.append(Math.round(Math.random() * 9));
        }
//		System.out.println(stringBuilder.toString() + " : " + stringBuilder.toString().length() + " : Max " + max);
        return stringBuilder.toString();
    }
}

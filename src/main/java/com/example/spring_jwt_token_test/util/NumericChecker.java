package com.example.spring_jwt_token_test.util;

import org.springframework.stereotype.Service;

@Service
public class NumericChecker {

    public  boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }



}

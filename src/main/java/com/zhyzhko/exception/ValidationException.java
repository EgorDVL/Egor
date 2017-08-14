package com.zhyzhko.exception;

import java.util.Map;

/**
 * Created on 02.08.17.
 */
public class ValidationException extends RuntimeException {
    Map<String, String> errorMap;

    public ValidationException(Map<String, String> errorMap) {
        super();
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }
}

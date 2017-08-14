package com.zhyzhko.web.controllersMVC;

import com.zhyzhko.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by user on 11.07.17.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Map<String, String> handleControllerException(ValidationException ex) {
        return ex.getErrorMap();
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Map<String, String> someHandleControllerException() {
        Map<String, String> error = new HashMap<>();
        error.put("msg", "Internal server error");
        return error;
    }
}



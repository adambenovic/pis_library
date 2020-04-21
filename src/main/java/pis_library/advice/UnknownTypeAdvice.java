package pis_library.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pis_library.exception.UnknownTypeException;

@ControllerAdvice
public class UnknownTypeAdvice {
    @ResponseBody
    @ExceptionHandler(UnknownTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String missingParameterHandler(UnknownTypeException ex) {
        return ex.getMessage();
    }
}

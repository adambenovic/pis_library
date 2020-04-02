package pis_library.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pis_library.exception.ReaderNotFoundException;

@ControllerAdvice
public class ReaderNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ReaderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(ReaderNotFoundException ex) {
        return ex.getMessage();
    }
}

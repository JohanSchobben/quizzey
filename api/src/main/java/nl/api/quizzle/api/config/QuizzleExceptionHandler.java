package nl.api.quizzle.api.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import nl.api.quizzle.api.dtos.ExceptionResponse;

@ControllerAdvice
public class QuizzleExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HttpStatus givenStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        var errorList = new HashMap<String, List<String>>();
        for (var err : ex.getFieldErrors()) {
            var name = err.getField();
            if (!errorList.containsKey(name)) {
                errorList.put(name, new ArrayList<>());
            }
            var list = errorList.get(name);
            list.add(err.getCode());
        }

        ExceptionResponse<Map<String, List<String>>> body = new ExceptionResponse<>(givenStatus, ex.getMessage(), errorList);
        return this.handleExceptionInternal(ex, body, headers, givenStatus, request);
    }
    
}

package nl.api.quizzle.api.dtos;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse<T> {
    private Date date;
    private HttpStatus status;
    private String message;
    private T errors;

    public ExceptionResponse(HttpStatus status, String message, T errors) {
        this.date = new Date();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ExceptionResponse(HttpStatus status, String message) {
        this(status, message, null);
    }
    
    public ExceptionResponse(HttpStatus status) {
        this(status, "an error occured");
    }

    public ExceptionResponse() {
        this(HttpStatus.INTERNAL_SERVER_ERROR, "an error occured");
    }

}

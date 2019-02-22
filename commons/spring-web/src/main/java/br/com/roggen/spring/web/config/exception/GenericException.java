package br.com.roggen.spring.web.config.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Map;

@Data
public class GenericException extends RuntimeException{

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    private String error;
    private Map<? extends Serializable,? extends Serializable> errors;

    public GenericException(Map<? extends Serializable,? extends Serializable> errors, String message){
        super(message);
        this.error = message;
        this.errors = errors;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public GenericException(String message){
        this(null, message);
    }

    public GenericException(HttpStatus responseStatus){
        this.status = responseStatus;
        this.error = responseStatus.getReasonPhrase();
    }

    public GenericException(String message, HttpStatus responseStatus) {
        super(message);
        this.error = message;
        this.status = responseStatus;
    }

}

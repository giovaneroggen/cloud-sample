package br.com.roggen.spring.web.config;

import br.com.roggen.spring.web.config.exception.GenericException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Configuration
@RestControllerAdvice
public class ControllerAdviceConfiguration {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<Response> handler(GenericException e){
        final HttpStatus status = e.getStatus();
        final Response response = new Response(status.getReasonPhrase(), status.value(), e.getError(), e.getErrors());
        return ResponseEntity.status(status)
                             .body(response);
    }

    @Data
    @AllArgsConstructor
    public static class Response{
        private String status;
        private Integer code;
        private String error;
        private Map errors;
    }
}

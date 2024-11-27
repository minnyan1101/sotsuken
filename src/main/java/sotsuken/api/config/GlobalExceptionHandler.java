package sotsuken.api.config;

import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = ErrorResponseException.class)
    public ProblemDetail handleAll(ErrorResponseException ex) {
        return ex.getBody();
    }
}

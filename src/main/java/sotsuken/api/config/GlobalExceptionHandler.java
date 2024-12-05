package sotsuken.api.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import sotsuken.api.model.exception.LectureNameValidationException;
import sotsuken.api.model.exception.SubjectDateValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler
    public ProblemDetail handleSubjectDateValidationException(SubjectDateValidationException ex, WebRequest request) {
        return createProblemDetail(ex, HttpStatus.BAD_REQUEST, "", null, null, request);
    }

    @ExceptionHandler
    public ProblemDetail handleLectureNameValidationException(LectureNameValidationException ex, WebRequest request) {
        return createProblemDetail(ex, HttpStatus.BAD_REQUEST, "", null, null, request);
    }
}

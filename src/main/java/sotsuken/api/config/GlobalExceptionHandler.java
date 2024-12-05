package sotsuken.api.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import sotsuken.api.model.exception.ClassNameValidationException;
import sotsuken.api.model.exception.LecturePeriodsValidationException;
import sotsuken.api.model.exception.StudentIdValidationExseption;
import sotsuken.api.model.exception.LectureNameValidationException;
import sotsuken.api.model.exception.SubjectDateValidationException;
import sotsuken.api.model.exception.TeacherIdValidationException;
import sotsuken.api.model.exception.SubjectNameValidationException;
import sotsuken.api.model.exception.TeacherNameValidationException;

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

    @ExceptionHandler
    public ProblemDetail handleTeacherIdValidationException(TeacherIdValidationException ex, WebRequest request) {
        return createProblemDetail(ex, HttpStatus.BAD_REQUEST, "", null, null, request);
    }
    
    @ExceptionHandler
    public ProblemDetail handleSubjectNameValidationException(SubjectNameValidationException ex, WebRequest request) {
        return createProblemDetail(ex, HttpStatus.BAD_REQUEST, "", null, null, request);
    }

    @ExceptionHandler
    public ProblemDetail handleTeacherNameValidationException(TeacherNameValidationException ex, WebRequest request) {
        return createProblemDetail(ex, HttpStatus.BAD_REQUEST, "", null, null, request);
    }
    
    @ExceptionHandler
    public ProblemDetail handleClassNameValidationException(ClassNameValidationException ex, WebRequest request){
        return createProblemDetail(ex,HttpStatus.BAD_REQUEST, "", null, null, request);
    }
    
    @ExceptionHandler
    public ProblemDetail handleLecturePeriodsValidationException(LecturePeriodsValidationException ex, WebRequest request){
        return createProblemDetail(ex, HttpStatus.BAD_REQUEST,"", null, null, request);
    }

    @ExceptionHandler
    public ProblemDetail handleStudentValidationException(StudentIdValidationExseption ex, WebRequest request){
        return createProblemDetail(ex, HttpStatus.BAD_REQUEST,"", null, null, request);
    }
}

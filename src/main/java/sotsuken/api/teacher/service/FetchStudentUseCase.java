package sotsuken.api.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import sotsuken.api.model.Student;
import sotsuken.api.repository.StudentRepository;
import sotsuken.api.teacher.controller.StudentStatusResponse;

@Service
public class FetchStudentUseCase {
    
    @Autowired
    StudentRepository studentRepository;

    public StudentStatusResponse handle(String userId, String studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        return new StudentStatusResponse(student.getId(), student.getName(), student.getClassId(), student.getClassName());
    }
}

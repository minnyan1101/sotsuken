package sotsuken.api.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import sotsuken.api.model.Student;
import sotsuken.api.model.StudentClass;
import sotsuken.api.repository.StudentClassRepository;
import sotsuken.api.repository.StudentRepository;
import sotsuken.api.teacher.controller.StudentStatusResponse;

@Service
public class ChangeStudentStatusUseCase {
    
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentClassRepository studentClassRepository;

    public StudentStatusResponse handle(String userId, String studentId, String studentName, Long classId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        StudentClass studentclass = studentClassRepository.findById(classId).orElseThrow(() -> new ErrorResponseException(HttpStatus.BAD_REQUEST));
        
        student.changeName(studentName);
        student.changeClass(studentclass);

        Student savedStudent = studentRepository.save(student);
        
        return new StudentStatusResponse(savedStudent.getId(), savedStudent.getName(), savedStudent.getClassId(), savedStudent.getClassName());
    }
}

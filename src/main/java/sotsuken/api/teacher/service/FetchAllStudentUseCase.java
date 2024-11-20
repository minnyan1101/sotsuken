package sotsuken.api.teacher.service;

import java.util.ArrayList;
import java.util.List;

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
public class FetchAllStudentUseCase {
    
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentClassRepository studentClassRepository;

    public List<StudentStatusResponse> handle(String userId) {
        List<Student> students = studentRepository.findAll();
        
        List<StudentStatusResponse> res = new ArrayList<>();
        for (Student student: students) {
            res.add(new StudentStatusResponse(student.getId(), student.getName(), student.getClassId(), student.getClassName()));
        }
            return res;
        
    }    
    
    public List<StudentStatusResponse> handle(String userId, long classId) {
        StudentClass filterClass= studentClassRepository.findById(classId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        List<Student> students = studentRepository.findByStudentClass(filterClass);
        
        List<StudentStatusResponse> res = new ArrayList<>();
        for (Student student: students) {
            res.add(new StudentStatusResponse(student.getId(), student.getName(), student.getClassId(), student.getClassName()));
        }
            return res;
        
    }
}

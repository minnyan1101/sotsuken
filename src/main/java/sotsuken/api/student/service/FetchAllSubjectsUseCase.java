package sotsuken.api.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import sotsuken.api.model.Student;
import sotsuken.api.model.Subject;
import sotsuken.api.repository.StudentRepository;
import sotsuken.api.repository.SubjectRepository;
import sotsuken.api.student.controller.SubjectsResponse;

@Service
public class FetchAllSubjectsUseCase {
    
    @Autowired
    SubjectRepository subjectRepository;
    
    @Autowired
    StudentRepository studentRepository;

    public List<SubjectsResponse> hanlde(String userId) {
        Student student = studentRepository.findById(userId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        List<Subject> subjects = subjectRepository.findAllByJoinedStudents(student);

        List<SubjectsResponse> res = new ArrayList<>();
        for (Subject subject: subjects) {
            res.add(new SubjectsResponse(subject.getId(), subject.getName(), subject.getDetail(), subject.getStartDate(), subject.getFinishDate(), subject.getTeacherId()));
        }

        return res;
    }
}
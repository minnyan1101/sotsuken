package sotsuken.api.teacher.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import sotsuken.api.model.Student;
import sotsuken.api.model.Subject;
import sotsuken.api.model.Teacher;
import sotsuken.api.repository.StudentRepository;
import sotsuken.api.repository.SubjectRepository;
import sotsuken.api.repository.TeacherRepository;
import sotsuken.api.teacher.controller.SubjectResponse;

@Service
public class EditSubjectUseCase {
    
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    StudentRepository studentRepository;

    public SubjectResponse handle(String userId, Long subjectId, String subjectName, LocalDate startDate, LocalDate finishDate, String teacherId, List<String> studentIds) {
        Subject editSubject = subjectRepository.findById(subjectId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        Teacher newTeacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ErrorResponseException(HttpStatus.BAD_REQUEST));
        List<Student> newStudents = studentRepository.findAllById(studentIds);

        editSubject.changeName(subjectName);
        editSubject.changeStartDate(startDate);
        editSubject.changeFinishDate(finishDate);
        editSubject.changeTeacher(newTeacher);
        editSubject.setJoinedStudents(newStudents);

        Subject savedSubject = subjectRepository.save(editSubject);

        return new SubjectResponse(savedSubject.getId(), savedSubject.getName(), savedSubject.getStartDate(), savedSubject.getFinishDate(), savedSubject.getTeacherId(), savedSubject.getJoinedStudentIds());
    }
}
package sotsuken.api.teacher.service;

import java.time.LocalDate;
import java.util.ArrayList;
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
public class CreateSubjectUseCase {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    public SubjectResponse handle(String userId, String subjectName, LocalDate startDate, LocalDate finishDate,
            String teacherId, List<String> studentIds) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.BAD_REQUEST));

        List<Student> students = new ArrayList<>();
        for (String studentId : studentIds) {
            students.add(studentRepository.findById(studentId)
                    .orElseThrow(() -> new ErrorResponseException(HttpStatus.BAD_REQUEST)));
        }

        Subject newSubject = new Subject(
                null,
                subjectName,
                "",
                startDate,
                finishDate,
                teacher,
                new ArrayList<>(),
                students);
                
        Subject savedSubject = subjectRepository.save(newSubject);

        return new SubjectResponse(
                savedSubject.getId(), savedSubject.getName(), savedSubject.getStartDate(), savedSubject.getFinishDate(),
                savedSubject.getTeacherId(), savedSubject.getJoinedStudentIds());
    }
}

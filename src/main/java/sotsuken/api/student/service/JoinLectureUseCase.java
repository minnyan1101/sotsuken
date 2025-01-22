package sotsuken.api.student.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import sotsuken.api.model.Attendance;
import sotsuken.api.model.AttendanceState;
import sotsuken.api.model.Lecture;
import sotsuken.api.model.Student;
import sotsuken.api.model.Subject;
import sotsuken.api.repository.AttendanceRepository;
import sotsuken.api.repository.LectureRepository;
import sotsuken.api.repository.StudentRepository;
import sotsuken.api.repository.SubjectRepository;
import sotsuken.api.student.controller.JoinStatusResponse;

@Service
public class JoinLectureUseCase {
    
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    StudentRepository studentRepository;

    public JoinStatusResponse handle(String userId, Long subjectId, Long lectureId, Long joinCode) {
        Student student = studentRepository.findById(userId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (! subject.containLectureById(lectureId)) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }

        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
     
        Attendance attendance = attendanceRepository.findByLectureAndStudent(lecture, student).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        // TODO Lectureの講義時間内の出席申請のみを認める処理

        if (! lecture.equalJoinCode(joinCode)) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST);
        }

        attendance.changeState(AttendanceState.ATTENDANCE);

        attendanceRepository.save(attendance);

        return new JoinStatusResponse(subject.getId(), subject.getName(), lecture.getId(), lecture.getName());
    }
}

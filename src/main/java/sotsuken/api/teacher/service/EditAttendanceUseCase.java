package sotsuken.api.teacher.service;

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
import sotsuken.api.teacher.controller.StudentLectureAttendanceResponce;

@Service
public class EditAttendanceUseCase {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public StudentLectureAttendanceResponce handle(String userId, Long subjectId, Long lectureId, String studentId,
            AttendanceState state, boolean isLateness, boolean isLeaveEarly) {

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (!subject.containLectureById(lectureId)) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }

        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        Attendance editAttendance = attendanceRepository.findByLectureAndStudent(lecture, student)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        editAttendance.changeState(state);
        editAttendance.changeLateness(isLateness);
        editAttendance.changeLeaveEarly(isLeaveEarly);

        Attendance savedAttendance = attendanceRepository.save(editAttendance);

        return new StudentLectureAttendanceResponce(
                lecture.getSubject().getId(),
                savedAttendance.getLecture().getId(),
                savedAttendance.getStudent().getId(),
                savedAttendance.getState().toString(),
                savedAttendance.isLateness(),
                savedAttendance.isLeaveEarly());
    }
}

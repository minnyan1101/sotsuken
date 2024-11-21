package sotsuken.api.teacher.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import sotsuken.api.repository.SubjectRepository;
import sotsuken.api.teacher.controller.CreateSubjectLectureRequest;
import sotsuken.api.teacher.controller.SubjectLectureResponse;

@Service
public class AddLectureUseCase {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    Random rand = new Random();

    public List<SubjectLectureResponse> handle(String userId, Long subjectId,
            List<CreateSubjectLectureRequest> requests) {
        List<SubjectLectureResponse> res = new ArrayList<>();
        for (CreateSubjectLectureRequest request : requests) {
            res.add(handle(userId, subjectId, request.lectureName, request.date, request.periods));
        }
        return res;
    }

    public SubjectLectureResponse handle(String userId, Long subjectId, String lectureName, LocalDate date,
            Long periods) {

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.BAD_REQUEST));
        Lecture newLecture = new Lecture(
                null,
                lectureName,
                subject,
                date,
                periods,
                generateJoinCode());
        Lecture savedLecture = lectureRepository.save(newLecture);

        for (Student student : subject.getJoinedStudents()) {// 参加する生徒の数だけ出席状況を作る
            Attendance newAttendance = new Attendance(
                    null,
                    savedLecture,
                    student,
                    AttendanceState.ABSENCE,
                    false,
                    false);
            attendanceRepository.save(newAttendance);
        }

        return new SubjectLectureResponse(subjectId, savedLecture.getId(), savedLecture.getName(),
                savedLecture.getStartDate(), savedLecture.getPeriods(), savedLecture.getJoinCode());
    }

    private long generateJoinCode() {
        return rand.nextLong() % 100000000;
    }

}

package sotsuken.api.teacher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import sotsuken.api.model.Attendance;
import sotsuken.api.model.Lecture;
import sotsuken.api.model.Subject;
import sotsuken.api.repository.AttendanceRepository;
import sotsuken.api.repository.LectureRepository;
import sotsuken.api.repository.SubjectRepository;
import sotsuken.api.teacher.controller.StudentLectureAttendanceResponse;

@Service
public class FetchAllAttendanceUseCase {

    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    LectureRepository lectureRepository;

    public List<StudentLectureAttendanceResponse> handle(Long subjectId, Long lectureId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
   
        if (! subject.containLectureById(lectureId)) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        List<Attendance> attendances = attendanceRepository.findByLecture(lecture);

        List<StudentLectureAttendanceResponse> res = new ArrayList<>();
        for (Attendance attendance: attendances) {
            res.add(new StudentLectureAttendanceResponse(
                subject.getId(),
                lecture.getId(),
                attendance.getStudent().getId(),
                attendance.getStudent().getName(),
                attendance.getState().toString(), 
                attendance.isLateness(), 
                attendance.isLeaveEarly()));
        }
        return res;
    }
}

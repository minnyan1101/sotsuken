package sotsuken.api.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import sotsuken.api.repository.StudentRepository;
import sotsuken.api.repository.SubjectRepository;
import sotsuken.api.student.controller.SubjectReportResponse;

@Service
public class FetchSubjectReportUseCase {
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    public SubjectReportResponse hanlde(String userId, Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        if (!subject.getJoinedStudentIds().contains(userId)) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }

        Student student = studentRepository.findById(userId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.BAD_REQUEST));

        Long totalLectures = (long) subject.totalLectures();
        List<Attendance> attendances = fetchStudentAttendanceBySubject(subject, student);
        Long totalAttendance = fetchTotalAttendance(attendances);
        Long totalAbcense = fetchTotalAbsence(attendances);
        Long totalLateness = fetchTotalLateness(attendances);
        Long totalLeaveEarly = fetchTotalLeaveEarly(attendances);

        return new SubjectReportResponse(subject.getId(), subject.getName(), subject.getDetail(), totalLectures,
                totalAttendance, totalAbcense, totalLateness, totalLeaveEarly);
    }

    // 選択した科目について、学生のすべてのAttendanceモデルを取得する
    private List<Attendance> fetchStudentAttendanceBySubject(Subject subject, Student student) {
        List<Attendance> attendances = new ArrayList<>();

        for (Lecture lecture : subject.getLectures()) {
            Optional<Attendance> optionalAttendance = attendanceRepository.findByLectureAndStudent(lecture, student);
            optionalAttendance.ifPresent(attendance -> attendances.add(attendance));
        }

        return attendances;
    }

    // 学生が選択した科目の合計出席数を集計
    private long fetchTotalAttendance(List<Attendance> attendances) {
        long totalAttendance = 0L;

        for (Attendance attendance : attendances) {
            switch (attendance.getState()) {
                case ATTENDANCE:
                    totalAttendance++;
                    break;

                default:
                    break;
            }
        }
        return totalAttendance;
    }

    // 学生が選択した科目の合計欠席数（欠席と公欠を含む）を集計
    private long fetchTotalAbsence(List<Attendance> attendances) {
        long totalAbsence = 0;
        for (Attendance attendance : attendances) {
            switch (attendance.getState()) {
                case OFFICIAL_ABSENCE, ABSENCE:
                    totalAbsence++;
                    break;

                default:
                    break;
            }
        }
        return totalAbsence;
    }

    // 学生が選択した科目の遅刻数を集計
    private long fetchTotalLateness(List<Attendance> attendances) {
        return attendances.stream().filter(attendance -> attendance.isLateness()).count();
    }

    // 学生が選択した科目の早退数を集計
    private long fetchTotalLeaveEarly(List<Attendance> attendances) {
        return attendances.stream().filter(attendance -> attendance.isLeaveEarly()).count();
    }
}

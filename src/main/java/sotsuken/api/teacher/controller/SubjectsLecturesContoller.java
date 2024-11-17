package sotsuken.api.teacher.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher/subjects/{subjectId}/lectures")
public class SubjectsLecturesContoller {
    @PostMapping("") // 講義追加
    public SubjectLectureResponse addLecture(
            @PathVariable("subjectId") Long subjectId,
            @RequestBody CreateSubjectLectureRequest reqeust) {
        return new SubjectLectureResponse(
                0L, 0L, "xxx", LocalDate.now(), 0L, 0L);

    }

    @GetMapping("") // 講義一覧
    public List<SubjectLectureResponse> lectureList(
            @PathVariable("subjectId") Long subjectId) {
        return List.of(new SubjectLectureResponse(
                0L, 0L, "xxx", LocalDate.now(), 0L, 0L));
    }

    @GetMapping("/{lectureId}") // 講義の編集画面の表示
    public SubjectLectureResponse editLecturelist(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureId) {
        return new SubjectLectureResponse(
                0L, 0L, "xxx", LocalDate.now(), 0L, 0L);
    }

    @PostMapping("/{lectureId}") // 講義の編集処理
    public SubjectLectureResponse editLecture(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureId,
            @RequestBody EditSubjectLectureRequest reqeust) {
        return new SubjectLectureResponse(
                0L, 0L, "xxx", LocalDate.now(), 0L, 0L);
    }

    @GetMapping("/{lectureId}/students")
    public List<StudentLectureAttendanceResponce> AttendanceEdit(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureIdLong) {
        return List.of(new StudentLectureAttendanceResponce(
                0L, 0L, 0L, "xxx", true, false));
    }

    @PostMapping("/{lectureId}/students/{studentId}")
    public List<StudentLectureAttendanceResponce> AttendanceEdit(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureIdLong,
            @PathVariable("studentId") Long studentId) {
        return List.of(new StudentLectureAttendanceResponce(
                0L, 0L, 0L, "xxx", true, false));
    }

}

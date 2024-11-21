package sotsuken.api.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sotsuken.api.teacher.service.EditLectureUseCase;
import sotsuken.api.teacher.service.AddLectureUseCase;
import sotsuken.api.teacher.service.FetchAllLectureUseCase;
import sotsuken.api.teacher.service.FetchLectureUseCase;

@RestController
@RequestMapping("/api/teacher/subjects/{subjectId}/lectures")
public class SubjectsLecturesContoller {
    
    @Autowired
    FetchAllLectureUseCase fetchAllLectureUseCase;

    @Autowired
    EditLectureUseCase editLectureUseCase;

    @Autowired
    FetchLectureUseCase fetchLectureUseCase;

    @Autowired
    AddLectureUseCase addLectureUseCase;
    
    @PostMapping("") // コマを追加する処理（講義追加）
    public List<SubjectLectureResponse> addLecture(
            @PathVariable("subjectId") Long subjectId,
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody List<CreateSubjectLectureRequest> reqeust) {
        return addLectureUseCase.handle(userDetails.getUsername(),subjectId,reqeust);

    }

    @GetMapping("") // 授業のコマ一覧表示（講義一覧）
    public List<SubjectLectureResponse> fetchAllLecture(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("subjectId") Long subjectId) {
        return fetchAllLectureUseCase.handle(userDetails.getUsername(),subjectId);
    }

    @GetMapping("/{lectureId}") // 講義の編集画面の表示（講義の編集）
    public SubjectLectureResponse fetchLecture(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureId) {
        return fetchLectureUseCase.handle(userDetails.getUsername(), subjectId, lectureId);
    }

    @PostMapping("/{lectureId}") // 講義の編集処理（講義の編集）
    public SubjectLectureResponse editLecture(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureId,
            @RequestBody EditSubjectLectureRequest reqeust) {
        return editLectureUseCase.handle(subjectId, lectureId, reqeust.lectureName, reqeust.date, reqeust.periods);
    }

    @GetMapping("/{lectureId}/students")//出欠確認画面の表示（生徒の出欠編集）
    public List<StudentLectureAttendanceResponce> fetchAllAttendance(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureIdLong) {
        return List.of(new StudentLectureAttendanceResponce(
                0L, 0L, 0L, "xxx", true, false));
    }

    @PostMapping("/{lectureId}/students/{studentId}")//出欠確認画面の編集（生徒の出欠編集）
    public StudentLectureAttendanceResponce editAttendance(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureIdLong,
            @PathVariable("studentId") Long studentId) {
        return new StudentLectureAttendanceResponce(
                0L, 0L, 0L, "xxx", true, false);
    }

}

package sotsuken.api.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import sotsuken.api.teacher.service.EditLectureUseCase;
import sotsuken.api.teacher.service.FetchAllAttendanceUseCase;
import sotsuken.api.teacher.service.AddLectureUseCase;
import sotsuken.api.teacher.service.EditAttendanceUseCase;
import sotsuken.api.teacher.service.FetchAllLectureUseCase;
import sotsuken.api.teacher.service.FetchLectureUseCase;

@RestController
@RequestMapping("/api/teacher/subjects/{subjectId}/lectures")
@Tag(name = "Teacher API")
public class SubjectsLecturesController {

    @Autowired
    FetchAllLectureUseCase fetchAllLectureUseCase;

    @Autowired
    EditLectureUseCase editLectureUseCase;

    @Autowired
    FetchLectureUseCase fetchLectureUseCase;

    @Autowired
    FetchAllAttendanceUseCase fetchAllAttendanceUseCase;

    @Autowired
    AddLectureUseCase addLectureUseCase;

    @Autowired
    EditAttendanceUseCase editAttendanceUseCase;

    @PostMapping("") // コマを追加する処理（講義追加）
    @Operation(summary = "新しい講義の追加")
    public List<SubjectLectureResponse> addLecture(
            @PathVariable("subjectId") Long subjectId,
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody @Validated List<@Valid CreateSubjectLectureRequest> reqeust) {
        return addLectureUseCase.handle(userDetails.getUsername(), subjectId, reqeust);

    }

    @GetMapping("") // 授業のコマ一覧表示（講義一覧）
    @Operation(summary = "特定の授業の講義の一覧の取得")
    public List<SubjectLectureResponse> fetchAllLecture(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("subjectId") Long subjectId) {
        return fetchAllLectureUseCase.handle(userDetails.getUsername(), subjectId);
    }

    @GetMapping("/{lectureId}") // 講義の編集画面の表示（講義の編集）
    @Operation(summary = "特定の講義の詳細を取得")
    public SubjectLectureResponse fetchLecture(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureId) {
        return fetchLectureUseCase.handle(userDetails.getUsername(), subjectId, lectureId);
    }

    @PostMapping("/{lectureId}") // 講義の編集処理（講義の編集）
    @Operation(summary = "特定の講義の編集")
    public SubjectLectureResponse editLecture(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureId,
            @RequestBody @Validated EditSubjectLectureRequest reqeust) {
        return editLectureUseCase.handle(subjectId, lectureId, reqeust.lectureName, reqeust.date, reqeust.periods);
    }

    @GetMapping("/{lectureId}/students") // 出欠確認画面の表示（生徒の出欠編集）
    @Operation(summary = "特定の講義を受講している学生の出席状況一覧の取得")
    public List<StudentLectureAttendanceResponse> fetchAllAttendance(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureId) {
        return fetchAllAttendanceUseCase.handle(subjectId, lectureId);
    }

    @PostMapping("/{lectureId}/students/{studentId}") // 出欠確認画面の編集（生徒の出欠編集）
    @Operation(summary = "特定の講義を受講している特定学生の出席状況の変更")
    public StudentLectureAttendanceResponse editAttendance(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("lectureId") Long lectureId,
            @PathVariable("studentId") String studentId,
            @RequestBody @Validated EditAttendanceRequest request) {
        return editAttendanceUseCase.handle(userDetails.getUsername(), subjectId, lectureId, studentId, request.state,
                request.isLateness, request.isLeaveEarly);
    }

}

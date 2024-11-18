package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/teacher/subjects")
public class SubjectController {

    @GetMapping("") // 授業一覧表示
    public List<SubjectResponse> fetchAllSubject() {
        return List.of(new SubjectResponse(
                0L,
                "xxx",
                LocalDate.now(),
                LocalDate.now(),
                0L,
                List.of(0L)));
    }

    @PostMapping("") // 新しく授業を作成
    public SubjectResponse createSubject(@RequestBody CreateSubjectRequest createsubject) {
        return new SubjectResponse(
                0L,
                "xxx",
                LocalDate.now(),
                LocalDate.now(),
                0L,
                List.of(0L));
    }

    @GetMapping("/{subjectId}") // 授業データの取得
    public SubjectResponse fetchSubject(@PathVariable("subjectId") Long subjectId) {
        return new SubjectResponse(
                0L,
                "xxx",
                LocalDate.now(),
                LocalDate.now(),
                0L,
                List.of(0L));
    }

    @PostMapping("/{subjectId}") // 授業内容の編集
    public SubjectResponse EditSubject(
            @PathVariable("subjectId") Long subjectId,
            @RequestBody EditSubjectRequest EditSubject) {
        return new SubjectResponse(
                0L,
                "xxx",
                LocalDate.now(),
                LocalDate.now(),
                0L,
                List.of(0L));
    }

}

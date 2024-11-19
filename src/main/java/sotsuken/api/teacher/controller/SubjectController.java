package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sotsuken.api.teacher.service.CreateClassesUseCase;
import sotsuken.api.teacher.service.FetchAllSubjectUseCase;
import sotsuken.api.teacher.service.FetchSubjectUseCase;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/teacher/subjects")
public class SubjectController {

    @Autowired
    FetchSubjectUseCase fetchSubjectUseCase;

    @Autowired
    FetchAllSubjectUseCase fetchAllSubjectUseCase;

    @GetMapping("") // 授業一覧表示
    public List<SubjectResponse> fetchAllSubject(@AuthenticationPrincipal UserDetails userDetails) {
        return fetchAllSubjectUseCase.handle(userDetails.getUsername());
    }

    @PostMapping("") // 新しく授業を作成
    public SubjectResponse createSubject(@RequestBody CreateSubjectRequest createsubject) {
        return new SubjectResponse(
                0L,
                "xxx",
                LocalDate.now(),
                LocalDate.now(),
                "xxx",
                List.of("xxx"));
    }

    @GetMapping("/{subjectId}") // 授業データの取得
    public SubjectResponse fetchSubject(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("subjectId") Long subjectId) {
        return fetchSubjectUseCase.handle(userDetails.getUsername(),subjectId);
             
    }

    @PostMapping("/{subjectId}") // 授業内容の編集
    public SubjectResponse editSubject(
            @PathVariable("subjectId") Long subjectId,
            @RequestBody EditSubjectRequest editSubject) {
        return new SubjectResponse(
                0L,
                "xxx",
                LocalDate.now(),
                LocalDate.now(),
                "xxx",
                List.of("xxx"));
    }

}

package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sotsuken.api.teacher.service.CreateSubjectUseCase;
import sotsuken.api.teacher.service.EditSubjectUseCase;
import sotsuken.api.teacher.service.FetchAllSubjectUseCase;
import sotsuken.api.teacher.service.FetchSubjectUseCase;

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

    @Autowired
    CreateSubjectUseCase createSubjectUseCase;
    
    @Autowired
    EditSubjectUseCase editSubjectUseCase;

    @GetMapping("") // 授業一覧表示(授業一覧)
    public List<SubjectResponse> fetchAllSubject(@AuthenticationPrincipal UserDetails userDetails) {
        return fetchAllSubjectUseCase.handle(userDetails.getUsername());
    }

    @PostMapping("") // 新しく授業を作成（授業の追加）（学生選択）
    public SubjectResponse createSubject(@AuthenticationPrincipal UserDetails userDetails,
            @RequestBody CreateSubjectRequest createsubject) {
        return createSubjectUseCase.handle(userDetails.getUsername(), createsubject.subjectName,
                createsubject.startDate, createsubject.finishDate, createsubject.teacherId, createsubject.studentIds);
    }

    @GetMapping("/{subjectId}") // 授業データの取得
    public SubjectResponse fetchSubject(@AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("subjectId") Long subjectId) {
        return fetchSubjectUseCase.handle(userDetails.getUsername(), subjectId);

    }

    @PostMapping("/{subjectId}") // 授業内容の編集（授業の編集）
    public SubjectResponse editSubject(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("subjectId") Long subjectId,
            @RequestBody EditSubjectRequest editSubject) {
        return editSubjectUseCase.handle(userDetails.getUsername(), subjectId, editSubject.subjectName, editSubject.startDate, editSubject.finishDate, editSubject.teacherId, editSubject.studentIds);
    }
}

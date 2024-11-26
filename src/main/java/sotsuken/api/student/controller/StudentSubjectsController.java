package sotsuken.api.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import sotsuken.api.student.service.FetchAllSubjectsUseCase;
import sotsuken.api.student.service.FetchSubjectReportUseCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/student/subjects")
@Tag(name = "Student API")
public class StudentSubjectsController {

    @Autowired
    FetchSubjectReportUseCase fetchSubjectReportUseCase;

    @Autowired
    FetchAllSubjectsUseCase fetchAllSubjectsUseCase;

    @GetMapping("")
    @Operation(summary = "学生が参加している授業の一覧")
    public List<SubjectsResponse> fetchAllSubjects(
        @AuthenticationPrincipal UserDetails userDetails
    ) {
        return fetchAllSubjectsUseCase.hanlde(userDetails.getUsername());
    }
    
    @GetMapping("/{subjectId}")
    @Operation(summary = "学生が参加している指定したID授業の情報")
    public SubjectReportResponse fetchSubjectReport(
        @AuthenticationPrincipal UserDetails userDetails,
        @PathVariable("subjectId") Long subjectId
    ) {
        return fetchSubjectReportUseCase.hanlde(userDetails.getUsername(), subjectId);
    }
    
}

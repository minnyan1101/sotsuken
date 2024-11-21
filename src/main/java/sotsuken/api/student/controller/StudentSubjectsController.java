package sotsuken.api.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sotsuken.api.student.service.FetchSubjectReportUseCase;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/students/subjects")
public class StudentSubjectsController {

    @Autowired
    FetchSubjectReportUseCase fetchSubjectReportUseCase;

    @GetMapping("")
    public SubjectsResponse fetchAllSubjects() {
        return new SubjectsResponse(
            0L,
            "xxx",
            "xxx",
            LocalDate.now(),
            LocalDate.now(),
            0L
        );
    }
    
    @GetMapping("/{subjectId}")
    public SubjectReportResponse fetchSubjectReport(
        @AuthenticationPrincipal UserDetails userDetails,
        @PathVariable("subjectId") Long subjectId
    ) {
        return fetchSubjectReportUseCase.hanlde(userDetails.getUsername(), subjectId);
    }
    
}

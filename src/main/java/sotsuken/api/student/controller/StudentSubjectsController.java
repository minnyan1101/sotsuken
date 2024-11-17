package sotsuken.api.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/students/subjects")
public class StudentSubjectsController {

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
        @PathVariable("subjectId") Long subjectId
    ) {
        return new SubjectReportResponse(
            0L,
            "xxx",
            "xxx",
            0L,
            0L,
            0L,
            0L,
            0L
        );
    }
    
}

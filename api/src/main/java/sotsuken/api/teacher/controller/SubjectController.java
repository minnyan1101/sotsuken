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

    @GetMapping("")
    public List<SubjectResponse> fetchAllSubject() {
        return List.of(new SubjectResponse(
                0L,
                "xxx",
                LocalDate.now(),
                LocalDate.now(),
                0L,
                List.of(0L)));
    }

    @PostMapping("")
    public SubjectResponse createSubject(@RequestBody CreateSubjectRequest createsubject) {
        return new SubjectResponse(
                0L,
                "xxx",
                LocalDate.now(),
                LocalDate.now(),
                0L,
                List.of(0L));
    }

    @GetMapping("/{subjectId}")
    public SubjectResponse fetchSubject(@PathVariable("subjectId") Long subjectId) {
        return new SubjectResponse(
                0L,
                "xxx",
                LocalDate.now(),
                LocalDate.now(),
                0L,
                List.of(0L));
    }

    @PostMapping("/{subjectId}")
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

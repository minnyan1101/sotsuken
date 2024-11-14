package sotsuken.api.teacher.controller;

import java.time.LocalDate;
import java.util.List;

public class CreateSubjectRequest {
    public String subjectName;
    public LocalDate starDate;
    public LocalDate finishDate;
    public Long teacherId;
    public List<Long> studentids;

    public CreateSubjectRequest(String subjectName, LocalDate starDate, LocalDate finishDate,
            Long teacherId, List<Long> studentids) {
        this.subjectName = subjectName;
        this.starDate = starDate;
        this.finishDate = finishDate;
        this.teacherId = teacherId;
        this.studentids = studentids;
    }
}

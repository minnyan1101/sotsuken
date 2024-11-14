package sotsuken.api.teacher.controller;

import java.time.LocalDate;
import java.util.List;

public class EditSubjectRequest {
    public String subjectName;
    public LocalDate starDate;
    public LocalDate finishDate;
    public Long teacherId;
    public List<Long> studentIds;

    public EditSubjectRequest(String subjectName, LocalDate starDate, LocalDate finishDate, Long teacherId,
            List<Long> studentIds) {
        this.subjectName = subjectName;
        this.starDate = starDate;
        this.finishDate = finishDate;
        this.teacherId = teacherId;
        this.studentIds = studentIds;
    }
}

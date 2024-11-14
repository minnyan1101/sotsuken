package sotsuken.api.teacher.controller;

import java.time.LocalDate;
import java.util.List;

public class SubjectResponse {
    public Long subjectId;
    public String subjectName;
    public LocalDate startDate;
    public LocalDate finishDate;
    public Long teacherId;
    public List<Long> studentIds;

    public SubjectResponse(Long subjectId, String subjectName, LocalDate startDate, LocalDate finishDate,
            Long teacherId, List<Long> studentIds) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.teacherId = teacherId;
        this.studentIds = studentIds;
    }
}

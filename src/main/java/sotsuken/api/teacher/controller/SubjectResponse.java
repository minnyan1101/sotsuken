package sotsuken.api.teacher.controller;

import java.time.LocalDate;
import java.util.List;

public class SubjectResponse {
    public Long subjectId;//　授業ID
    public String subjectName;//　授業名
    public LocalDate startDate;//　開始日
    public LocalDate finishDate;//　終了日
    public Long teacherId;//　先生ID
    public List<Long> studentIds;//　学生ID

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

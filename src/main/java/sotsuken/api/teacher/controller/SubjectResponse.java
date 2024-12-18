package sotsuken.api.teacher.controller;

import java.time.LocalDate;
import java.util.List;

public class SubjectResponse {
    public Long subjectId;//　授業ID
    public String subjectName;//　授業名
    public LocalDate startDate;//　開始日
    public LocalDate finishDate;//　終了日
    public String teacherId;//　先生ID
    public List<String> studentIds;//　学生ID

    public SubjectResponse(Long subjectId, String subjectName, LocalDate startDate, LocalDate finishDate,
            String teacherId, List<String> studentIds) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.teacherId = teacherId;
        this.studentIds = studentIds;
    }
}

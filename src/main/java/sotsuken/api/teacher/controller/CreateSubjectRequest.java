package sotsuken.api.teacher.controller;

import java.time.LocalDate;
import java.util.List;

public class CreateSubjectRequest {
    public String subjectName;//　授業名
    public LocalDate startDate;//　開始日
    public LocalDate finishDate;//　終了日
    public String teacherId;//　先生ID
    public List<String> studentIds;//　学生ID

    public CreateSubjectRequest(String subjectName, LocalDate starDate, LocalDate finishDate,
    String teacherId, List<String> studentIds) {
        this.subjectName = subjectName;
        this.startDate = starDate;
        this.finishDate = finishDate;
        this.teacherId = teacherId;
        this.studentIds = studentIds;
    }
}

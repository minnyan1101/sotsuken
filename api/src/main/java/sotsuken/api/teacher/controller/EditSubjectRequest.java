package sotsuken.api.teacher.controller;

import java.time.LocalDate;
import java.util.List;

public class EditSubjectRequest {
    public String subjectName;//　授業名
    public LocalDate starDate;//　開始日
    public LocalDate finishDate;//　終了日
    public Long teacherId;//　先生ID
    public List<Long> studentIds;//　学生ID

    public EditSubjectRequest(String subjectName, LocalDate starDate, LocalDate finishDate, Long teacherId,
            List<Long> studentIds) {
        this.subjectName = subjectName;
        this.starDate = starDate;
        this.finishDate = finishDate;
        this.teacherId = teacherId;
        this.studentIds = studentIds;
    }
}
package sotsuken.api.teacher.controller;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotNull;

public class EditSubjectRequest {
    @NotNull
    public String subjectName;//　授業名
    @NotNull
    public LocalDate startDate;//　開始日
    @NotNull
    public LocalDate finishDate;//　終了日
    @NotNull
    public String teacherId;//　先生ID
    @NotNull
    public List<String> studentIds;//　学生ID

    public EditSubjectRequest(String subjectName, LocalDate startDate, LocalDate finishDate, String teacherId,
            List<String> studentIds) {
        this.subjectName = subjectName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.teacherId = teacherId;
        this.studentIds = studentIds;
    }
}

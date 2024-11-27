package sotsuken.api.teacher.controller;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class EditSubjectLectureRequest {
    @NotNull
    public String lectureName;//講義名
    @NotNull
    public LocalDate date;//日付
    @NotNull
    public Long periods;//時限数

    public EditSubjectLectureRequest(String lectureName, LocalDate date, Long periods) {
        this.lectureName = lectureName;
        this.date = date;
        this.periods = periods;
    }
}

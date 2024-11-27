package sotsuken.api.teacher.controller;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class CreateSubjectLectureRequest {
    @NotNull
    public String lectureName;
    @NotNull
    public LocalDate date;//日付
    @NotNull
    public Long periods;//時限数

    public CreateSubjectLectureRequest(String lectureName, LocalDate date, Long periods) {
        this.lectureName = lectureName;
        this.date = date;
        this.periods = periods;
    }
}

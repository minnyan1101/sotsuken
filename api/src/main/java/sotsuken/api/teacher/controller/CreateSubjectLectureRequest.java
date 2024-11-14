package sotsuken.api.teacher.controller;

import java.time.LocalDate;

public class CreateSubjectLectureRequest {
    public String lectureName;
    public LocalDate date;//日付
    public Long periods;//時限数

    public CreateSubjectLectureRequest(String lectureName, LocalDate date, Long periods) {
        this.lectureName = lectureName;
        this.date = date;
        this.periods = periods;
    }
}

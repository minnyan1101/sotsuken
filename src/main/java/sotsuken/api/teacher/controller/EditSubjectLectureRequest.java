package sotsuken.api.teacher.controller;

import java.time.LocalDate;

public class EditSubjectLectureRequest {
    public String lectureName;//講義名
    public LocalDate date;//日付
    public Long periods;//時限数

    public EditSubjectLectureRequest(String lectureName, LocalDate date, Long periods) {
        this.lectureName = lectureName;
        this.date = date;
        this.periods = periods;
    }
}
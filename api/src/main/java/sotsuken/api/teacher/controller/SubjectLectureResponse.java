package sotsuken.api.teacher.controller;

import java.time.LocalDate;

public class SubjectLectureResponse {
    public Long subjectId;// 教科ID
    public Long lectureId;// 時限毎のID
    public String lectureName;// 時限毎の名前
    public LocalDate date; // 日付
    public Long periods; // 何限目か
    public Long joinCode; // 暗証番号

    public SubjectLectureResponse(Long subjectId, Long lectureId, String lectureName, LocalDate date, Long periods,
            Long joinCode) {
        this.subjectId = subjectId;
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.date = date;
        this.periods = periods;
        this.joinCode = joinCode;
    }

}

package sotsuken.api.student.controller;

import java.time.LocalDate;

public class StudentSubjectResponse {
    public Long subjectId;
    public String subjectName;
    public LocalDate startDate;
    public LocalDate finishDate;
    public String teacherId;

    public StudentSubjectResponse(
        Long subjectId, 
        String subjectName, 
        LocalDate startDate, 
        LocalDate finishDate,
        String teacherId)
    {

        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.teacherId = teacherId;
    }

}

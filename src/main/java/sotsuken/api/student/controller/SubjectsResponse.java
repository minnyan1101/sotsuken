package sotsuken.api.student.controller;

import java.time.LocalDate;

public class SubjectsResponse {
    public Long subjectId;
    public String name;
    public String detail;
    public LocalDate startDate;
    public LocalDate endDate;
    public String teacherId;

    public SubjectsResponse(
        Long subjectId, 
        String name, 
        String detail, 
        LocalDate startDate, 
        LocalDate endDate,
        String teacherId)
    {

        this.subjectId = subjectId;
        this.name = name;
        this.detail = detail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

}

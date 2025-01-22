package sotsuken.api.student.controller;

public class JoinStatusResponse {
    public Long subjectId;
    public String subjectName;
    public Long lectureId;
    public String lectureName;
    
    public JoinStatusResponse(Long subjectId, String subjectName, Long lectureId, String lectureName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.lectureId = lectureId;
        this.lectureName = lectureName;
    }
}

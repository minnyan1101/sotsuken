package sotsuken.api.student.controller;

public class JoinStatusResponse {
    public Long subjectId;
    public Long lectureId;
    
    public JoinStatusResponse(Long subjectId, Long lectureId) {
        this.subjectId = subjectId;
        this.lectureId = lectureId;
    }
}

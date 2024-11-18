package sotsuken.api.student.controller;

public class JoinStatusResponse {
    public Long subjectId;
    public Long lectureId;
    public String joinState; // "success" | "failure" 
    
    public JoinStatusResponse(Long subjectId, Long lectureId, String joinState) {
        this.subjectId = subjectId;
        this.lectureId = lectureId;
        this.joinState = joinState;
    }
}

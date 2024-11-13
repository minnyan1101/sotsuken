package sotsuken.api.student.controller;

public class JoinLectureRequest {
    public Long subjectId;
    public Long lectureId;
    public Long joinCode;

    public JoinLectureRequest(Long subjectId, Long lectureId, Long joinCode) {
        this.subjectId = subjectId;
        this.lectureId = lectureId;
        this.joinCode = joinCode;
    }
}

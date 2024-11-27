package sotsuken.api.student.controller;

import jakarta.validation.constraints.NotNull;

public class JoinLectureRequest {
    @NotNull
    public Long subjectId;
    @NotNull
    public Long lectureId;
    @NotNull
    public Long joinCode;

    public JoinLectureRequest(Long subjectId, Long lectureId, Long joinCode) {
        this.subjectId = subjectId;
        this.lectureId = lectureId;
        this.joinCode = joinCode;
    }
}

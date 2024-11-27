package sotsuken.api.teacher.controller;

import jakarta.validation.constraints.NotNull;

public class StudentRequest {
    @NotNull
    public String studentName;
    @NotNull
    public Long classId;

    public StudentRequest(String studentName, Long classId) {
        this.studentName = studentName;
        this.classId = classId;
    }
}

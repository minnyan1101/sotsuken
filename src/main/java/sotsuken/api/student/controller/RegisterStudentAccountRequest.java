package sotsuken.api.student.controller;

import jakarta.validation.constraints.NotNull;

public class RegisterStudentAccountRequest {
    @NotNull
    public String studentId;
    @NotNull
    public String studentName;
    @NotNull
    public String password;
    @NotNull
    public Long classId;
}

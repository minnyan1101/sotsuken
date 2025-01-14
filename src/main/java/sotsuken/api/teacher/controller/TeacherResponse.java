package sotsuken.api.teacher.controller;

public class TeacherResponse {
    public String teacherId;
    public String name;

    public TeacherResponse(String teacherId, String name) {
        this.teacherId = teacherId;
        this.name = name;
    }
}

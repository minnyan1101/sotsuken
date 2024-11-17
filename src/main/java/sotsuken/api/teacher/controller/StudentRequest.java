package sotsuken.api.teacher.controller;

public class StudentRequest {
    public String studentName;
    public Long classId;

    public StudentRequest(String studentName, Long classId) {
        this.studentName = studentName;
        this.classId = classId;
    }
}

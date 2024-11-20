package sotsuken.api.teacher.controller;

public class StudentStatusResponse {
    public String studentId;
    public String studentName;
    public Long classId;
    public String className;
    
    public StudentStatusResponse(String studentId, String studentName, Long classId, String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
        this.className = className;
    }
}

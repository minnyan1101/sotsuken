package sotsuken.api.teacher.controller;

public class StudentStatusResponse {
    public long studentId;
    public String studentName;
    public long classId;
    public String className;
    
    public StudentStatusResponse(long studentId, String studentName, long classId, String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
        this.className = className;
    }
}

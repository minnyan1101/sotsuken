package sotsuken.api.teacher.controller;

public class StudentClassResponse {
    public Long classId; //クラスID
    public String className; //クラス名
    public StudentClassResponse(Long classId, String className) {
        this.classId = classId;
        this.className = className;
    }
}

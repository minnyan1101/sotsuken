package sotsuken.api.teacher.controller;

public class ClassResponse {
    public Long classId; //クラスID
    public String className; //クラス名
    public ClassResponse(Long classId, String className) {
        this.classId = classId;
        this.className = className;
    }
}

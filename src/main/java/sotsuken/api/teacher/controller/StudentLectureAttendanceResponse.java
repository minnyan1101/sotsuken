package sotsuken.api.teacher.controller;

public class StudentLectureAttendanceResponse {
    public Long subjectId;// 教科ID
    public Long lectureId;// 時限毎のID
    public String studentId;// 生徒ID
    public String studentName; // 生徒名
    public String attendanceState; // 出席
    public boolean isLateness; // 遅刻
    public boolean isLeaveEarly;// 早退

    public StudentLectureAttendanceResponse(Long subjectId, Long lectureId, String studentId, String studentName, String attendanceState,
            boolean isLateness, boolean isLeaveEarly) {
        this.subjectId = subjectId;
        this.lectureId = lectureId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.attendanceState = attendanceState;
        this.isLateness = isLateness;
        this.isLeaveEarly = isLeaveEarly;
    }
}
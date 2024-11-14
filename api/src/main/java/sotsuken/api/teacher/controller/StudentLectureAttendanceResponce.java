package sotsuken.api.teacher.controller;

public class StudentLectureAttendanceResponce {
    public Long subjectId;// 教科ID
    public Long lectureId;// 時限毎のID
    public Long studentId;// 生徒ID
    public String attendanceState; // 出席
    public boolean isLateness; // 遅刻
    public boolean isLeaveEarly;// 早退

    public StudentLectureAttendanceResponce(Long subjectId, Long lectureId, Long studentId, String attendanceState,
            boolean isLateness, boolean isLeaveEarly) {
        this.subjectId = subjectId;
        this.lectureId = lectureId;
        this.studentId = studentId;
        this.attendanceState = attendanceState;
        this.isLateness = isLateness;
        this.isLeaveEarly = isLeaveEarly;
    }
}
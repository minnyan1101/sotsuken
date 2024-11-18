package sotsuken.api.student.controller;

public class SubjectReportResponse {
    public Long subjectId;
    public String name;
    public String detail;
    public Long totalLectures; // 総講義数
    public Long totalAttendance; // 出席数
    public Long totalAbsence; // 欠席数
    public Long totalLateness; // 遅刻数
    public Long totalLeaveEarly; // 早退数
    
    public SubjectReportResponse(Long subjectId, String name, String detail, Long totalLectures, Long totalAttendance,
            Long totalAbsence, Long totalLateness, Long totalLeaveEarly) {
        this.subjectId = subjectId;
        this.name = name;
        this.detail = detail;
        this.totalLectures = totalLectures;
        this.totalAttendance = totalAttendance;
        this.totalAbsence = totalAbsence;
        this.totalLateness = totalLateness;
        this.totalLeaveEarly = totalLeaveEarly;
    }
}

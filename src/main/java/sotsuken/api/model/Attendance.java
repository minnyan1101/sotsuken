package sotsuken.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance {
    @Id
    private Long id;
    @ManyToOne
    private Lecture lecture;
    @Enumerated(EnumType.STRING)
    private AttendanceState state;
    private boolean isLateness;
    private boolean isLeaveEarly;

    public Attendance(Long id, Lecture lecture, AttendanceState state, boolean isLateness, boolean isLeaveEarly) {
        this.id = id;
        this.lecture = lecture;
        this.state = state;
        this.isLateness = isLateness;
        this.isLeaveEarly = isLeaveEarly;
    }

    public Long getId() {
        return id;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public AttendanceState getState() {
        return state;
    }

    public boolean isLateness() {
        return isLateness;
    }

    public boolean isLeaveEarly() {
        return isLeaveEarly;
    }
}

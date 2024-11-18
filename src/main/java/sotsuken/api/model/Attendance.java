package sotsuken.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendances")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public AttendanceState getState() {
        return state;
    }

    public void changeState(AttendanceState newState) {
        this.state = newState;
    }

    public boolean isLateness() {
        return isLateness;
    }

    public void changeLateness(boolean isLateness) {
        this.isLateness = isLateness;
    }

    public boolean isLeaveEarly() {
        return isLeaveEarly;
    }

    
    public void isLeaveEarly(boolean isLeaveEarly) {
        this.isLeaveEarly = isLeaveEarly;
    }
}

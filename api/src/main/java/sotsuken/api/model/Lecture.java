package sotsuken.api.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Lecture {
    @Id
    private Long id;
    @ManyToOne
    private Subject subject;
    private LocalDate startDate;
    private Long periods;
    private Long joinCode;
    @OneToMany
    private List<Attendance> attendanceStudents;

    public Lecture(Long id, Subject subject, LocalDate startDate, Long periods, Long joinCode,
            List<Attendance> attendanceStudents) {
        this.id = id;
        this.subject = subject;
        this.startDate = startDate;
        this.periods = periods;
        this.joinCode = joinCode;
        this.attendanceStudents = attendanceStudents;
    }

    public Long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Long getPeriods() {
        return periods;
    }

    public Long getJoinCode() {
        return joinCode;
    }

    public List<Attendance> getAttendanceStudents() {
        return attendanceStudents;
    }
}

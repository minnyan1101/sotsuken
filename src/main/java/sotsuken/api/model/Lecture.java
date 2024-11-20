package sotsuken.api.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lectures")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Subject subject;
    private LocalDate startDate;
    private Long periods;
    private Long joinCode;
    @OneToMany
    private List<Attendance> attendanceStudents;

    public Lecture() {
    }

    public Lecture(Long id, String name, Subject subject, LocalDate startDate, Long periods, Long joinCode,
            List<Attendance> attendanceStudents) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.startDate = startDate;
        this.periods = periods;
        this.joinCode = joinCode;
        this.attendanceStudents = attendanceStudents;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    
    public void changeStartDate(LocalDate newStartDate) {
        this.startDate = newStartDate;
    }

    public Long getPeriods() {
        return periods;
    }

    public void changePeriods(Long newPeriods) {
        this.periods = newPeriods;
    }

    public Long getJoinCode() {
        return joinCode;
    }

    public boolean equalJoinCode(Long joinCode) {
        return this.joinCode.equals(joinCode);
    }

    public List<Attendance> getAttendanceStudents() {
        return attendanceStudents;
    }
}

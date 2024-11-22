package sotsuken.api.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import sotsuken.api.model.exception.LectureNameValidationException;
import sotsuken.api.model.exception.LecturePeriodsValidationException;

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
    @JoinColumn(name = "lecture_id")
    private List<Attendance> attendanceStudents;

    public Lecture() {}

    public Lecture(Long id, String name, Subject subject, LocalDate startDate, Long periods, Long joinCode) {
        this.id = id;
        nameValidation(name);
        this.name = name;
        this.subject = subject;
        this.startDate = startDate;
        periodsValidation(periods);
        this.periods = periods;
        this.joinCode = joinCode;
    }

    private static void nameValidation(String name){
        if(! (1 <= name.length() && name.length() <= 32)){//nameが３２文字か判定する
            throw new LectureNameValidationException();
        }

        if((name.matches(".*\\v.*"))){// 改行に類する空白文字が文字列に含まれているか確認している
            throw new LectureNameValidationException();
        }
    }

    private static void periodsValidation(Long periods){
        if(periods < 0){//periodsがマイナスかどうか判定
            throw new LecturePeriodsValidationException();
        }
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void changeName(String name) {
        nameValidation(name);
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
        periodsValidation(periods);
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

    public void setAttendanceStudents(List<Attendance> attendances) {
        this.attendanceStudents = attendances;
    }
}

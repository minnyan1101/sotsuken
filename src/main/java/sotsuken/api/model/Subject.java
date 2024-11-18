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

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String detail;
    private LocalDate startDate;
    private LocalDate finishDate;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany
    @JoinColumn(name = "subject_id")
    private List<Lecture> lectures;

    @OneToMany
    private List<Student> joinedStudents;

    public Subject() {
    }

    public Subject(Long id, String name, String detail, LocalDate startDate, LocalDate finishDate, Teacher teacher,
            List<Lecture> lectures, List<Student> joinedStudents) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.teacher = teacher;
        this.lectures = lectures;
        this.joinedStudents = joinedStudents;

        validateStartDateToFinishDate(startDate, finishDate);
    }

    private static void validateStartDateToFinishDate(LocalDate startDate, LocalDate finishDate) {
        if (startDate.isBefore(finishDate)) {
            return;
        }

        throw new SubjectDateValidationException();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public String getDetail() {
        return detail;
    }

    public void changeDetail(String newDetail) {
        this.detail = newDetail;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void changeStartDate(LocalDate newStartDate) {
        validateStartDateToFinishDate(newStartDate, this.finishDate);

        this.startDate = newStartDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void changeFInishDate(LocalDate newFinishDate) {
        validateStartDateToFinishDate(this.startDate, newFinishDate);

        this.finishDate = newFinishDate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void changeTeacher(Teacher newTeacher) {
        this.teacher = newTeacher;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public List<Student> getJoinedStudents() {
        return joinedStudents;
    }
}

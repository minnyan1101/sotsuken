package sotsuken.api.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Subject {
    @Id
    private Long id;
    private String name;
    private String detail;
    private LocalDate startDate;
    private LocalDate finishDate;
    @ManyToOne
    private Teacher teacher;

    @OneToMany
    private List<Lecture> lectures;

    @OneToMany
    private List<Student> joinedStudents;

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
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public List<Student> getJoinedStudents() {
        return joinedStudents;
    }
}

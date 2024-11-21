package sotsuken.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Attendance;
import sotsuken.api.model.Lecture;
import sotsuken.api.model.Student;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findByLectureAndStudent(Lecture lecture, Student student);
    List<Attendance> findByLecture(Lecture lecture);
}

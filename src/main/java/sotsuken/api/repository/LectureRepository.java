package sotsuken.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Lecture;
import sotsuken.api.model.Subject;

public interface LectureRepository extends JpaRepository<Lecture, Long>{
    List<Lecture> findBySubject(Subject subject);
}

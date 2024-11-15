package sotsuken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long>{

}

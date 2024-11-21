package sotsuken.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Student;
import sotsuken.api.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findAllByJoinedStudents(Student student);
}

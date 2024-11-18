package sotsuken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}

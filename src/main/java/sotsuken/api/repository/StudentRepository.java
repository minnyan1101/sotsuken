package sotsuken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}

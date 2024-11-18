package sotsuken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
}

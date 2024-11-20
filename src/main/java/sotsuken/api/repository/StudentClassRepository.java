package sotsuken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.StudentClass;

public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {
    
}

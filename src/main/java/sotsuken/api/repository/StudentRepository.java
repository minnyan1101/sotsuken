package sotsuken.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Student;
import sotsuken.api.model.StudentClass;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByStudentClass(StudentClass clazz);
}

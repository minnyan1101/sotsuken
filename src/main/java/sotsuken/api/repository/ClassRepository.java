package sotsuken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {

}

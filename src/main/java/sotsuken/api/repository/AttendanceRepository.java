package sotsuken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    
}

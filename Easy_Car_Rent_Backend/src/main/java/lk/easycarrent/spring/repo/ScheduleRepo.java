package lk.easycarrent.spring.repo;

import lk.easycarrent.spring.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule, String> {
}

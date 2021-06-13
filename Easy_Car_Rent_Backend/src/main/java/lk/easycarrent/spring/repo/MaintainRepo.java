package lk.easycarrent.spring.repo;

import lk.easycarrent.spring.entity.Maintain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintainRepo extends JpaRepository<Maintain, String> {
}

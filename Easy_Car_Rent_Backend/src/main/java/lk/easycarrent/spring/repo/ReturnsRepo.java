package lk.easycarrent.spring.repo;

import lk.easycarrent.spring.entity.Returns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnsRepo extends JpaRepository<Returns, String> {
}

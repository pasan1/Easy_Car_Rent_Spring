package lk.easycarrent.spring.repo;

import lk.easycarrent.spring.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepo extends JpaRepository<Rent, String> {
}

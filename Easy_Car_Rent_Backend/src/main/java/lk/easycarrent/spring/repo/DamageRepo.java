package lk.easycarrent.spring.repo;

import lk.easycarrent.spring.entity.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageRepo extends JpaRepository<Damage, String> {
}

package lk.easycarrent.spring.repo;

import lk.easycarrent.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}

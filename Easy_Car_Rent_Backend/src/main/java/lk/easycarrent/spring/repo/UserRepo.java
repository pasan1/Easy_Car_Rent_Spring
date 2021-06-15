package lk.easycarrent.spring.repo;

import lk.easycarrent.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    @Query(value = "select * from User WHERE username=:username AND password=:pass",nativeQuery = true)
    User searchByUserNameAndPassword(@Param("username") String username, @Param("pass") String password);
}

package lk.easycarrent.spring.repo;

import lk.easycarrent.spring.entity.RentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentPaymentRepo extends JpaRepository<RentPayment, String>{
}

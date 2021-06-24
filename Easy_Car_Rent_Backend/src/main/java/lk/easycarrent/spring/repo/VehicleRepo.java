package lk.easycarrent.spring.repo;

import lk.easycarrent.spring.entity.Customer;
import lk.easycarrent.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    @Query(value = "select * from Vehicle WHERE regNumber LIKE %:sReg%",nativeQuery = true)
    List<Vehicle> searchByRegVehicle(@Param("sReg") String reg);
}

package lk.easycarrent.spring.dto;

import lk.easycarrent.spring.entity.Driver;
import lk.easycarrent.spring.entity.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleDTO {
    private String scheduleID;
    private RentDTO rentID;
    private DriverDTO driverID;
}

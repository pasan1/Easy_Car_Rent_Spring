package lk.easycarrent.spring.dto;

import lk.easycarrent.spring.entity.Customer;
import lk.easycarrent.spring.entity.Driver;
import lk.easycarrent.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentDTO {
    private String rentID;
    private String pickUpDate;
    private String pickOffDate;
    private String status;
    private String reason;
    private double totalFee;
    private String date;
    private CustomerDTO customer;
    private VehicleDTO vehicle;
    private DriverDTO driver;
}

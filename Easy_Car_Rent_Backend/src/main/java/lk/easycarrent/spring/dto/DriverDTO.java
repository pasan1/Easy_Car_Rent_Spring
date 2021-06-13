package lk.easycarrent.spring.dto;

import lk.easycarrent.spring.entity.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DriverDTO {
    private String driverID;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    private String nic;
    private List<Rent> rentOrder;
}

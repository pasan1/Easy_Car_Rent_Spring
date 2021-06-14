package lk.easycarrent.spring.dto;

import lk.easycarrent.spring.entity.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String customerID;
    private String firstName;
    private String lasTName;
    private String nicNumber;
    private String driveLicenseNumber;
    private String address;
    private String contactNumber;
    private List<RentDTO> rentOrder = new ArrayList<>();
}

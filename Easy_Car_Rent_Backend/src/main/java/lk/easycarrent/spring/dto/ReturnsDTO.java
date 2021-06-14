package lk.easycarrent.spring.dto;

import lk.easycarrent.spring.entity.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReturnsDTO {
    private String returnsID;
    private RentDTO rentID;
    private double feeReturn;
    private String reason;
}

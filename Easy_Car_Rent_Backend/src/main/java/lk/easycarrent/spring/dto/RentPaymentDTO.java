package lk.easycarrent.spring.dto;

import lk.easycarrent.spring.entity.RentPayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentPaymentDTO {
    private String paymentID;
    private RentPaymentDTO rentID;
    private String date;
    private double fee;
    private String method;
}

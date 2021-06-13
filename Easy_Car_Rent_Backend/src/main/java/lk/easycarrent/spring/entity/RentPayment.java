package lk.easycarrent.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentPayment {
    @Id
    private String paymentID;
    @OneToOne
    private RentPayment rentID;
    private String date;
    private double fee;
    private String method;
}

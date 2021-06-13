package lk.easycarrent.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Returns {
    @Id
    private String returnsID;
    @OneToOne
    private Rent rentID;
    private double feeReturn;
    private String reason;
}

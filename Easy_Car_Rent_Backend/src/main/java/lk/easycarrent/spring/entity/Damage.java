package lk.easycarrent.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Damage {
    @Id
    private String damageID;
    private double fee;
    private String reason;
    @OneToOne()
    private Returns returnsID;
}

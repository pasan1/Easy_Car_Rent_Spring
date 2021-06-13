package lk.easycarrent.spring.dto;

import lk.easycarrent.spring.entity.Returns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DamageDTO {
    private String damageID;
    private double fee;
    private String reason;
    private Returns returnsID;
}

package lk.easycarrent.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarImageDTO {
    private String vehicleID;
    private String imgPath;
}

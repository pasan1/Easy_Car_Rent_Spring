package lk.easycarrent.spring.dto;

import lk.easycarrent.spring.entity.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {
    private Long vehicleID;
    private String brand;
    private String model;
    private String type;
    private double extraFee;
    private String regNumber;
    private String color;
    private String passNumber;
    private String transmissionType;
    private String fuelType;
    private double dailyRent;
    private double monthlyRent;
    private String dailyKM;
    private String monthlyKM;
    private String fontView;
    private String sideView;
    private String backView;
    private String interiorView;
//    private List<RentDTO> rentOrder;


    public VehicleDTO(String brand, String model, String type, double extraFee, String regNumber, String color, String passNumber, String transmissionType, String fuelType, double dailyRent, double monthlyRent, String dailyKM, String monthlyKM, String fontView, String sideView, String backView, String interiorView) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.extraFee = extraFee;
        this.regNumber = regNumber;
        this.color = color;
        this.passNumber = passNumber;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
        this.dailyRent = dailyRent;
        this.monthlyRent = monthlyRent;
        this.dailyKM = dailyKM;
        this.monthlyKM = monthlyKM;
        this.fontView = fontView;
        this.sideView = sideView;
        this.backView = backView;
        this.interiorView = interiorView;
    }
}

package lk.easycarrent.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleID;//
    private String brand;//1
    private String model;//2
    private String type;//3
    private double extraFee;
    private String regNumber;//4
    private String color;//5
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
    @OneToMany(mappedBy = "vehicle",cascade = {CascadeType.ALL})
    private List<Rent> rentOrder;
}

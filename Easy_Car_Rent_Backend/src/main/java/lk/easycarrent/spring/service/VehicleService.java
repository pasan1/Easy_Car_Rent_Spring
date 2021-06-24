package lk.easycarrent.spring.service;


import lk.easycarrent.spring.dto.VehicleDTO;

import java.util.ArrayList;

public interface VehicleService {
    void addVehicle(VehicleDTO dto);

    void deleteVehicle(Long id);

    VehicleDTO searchVehicle(Long id);

    ArrayList<VehicleDTO> getAllVehicle();

    ArrayList<VehicleDTO> searchByRegVehicle(String reg);

    void updateVehicle(VehicleDTO dto);
}

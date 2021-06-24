package lk.easycarrent.spring.service.impl;

import lk.easycarrent.spring.dto.VehicleDTO;
import lk.easycarrent.spring.entity.Vehicle;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.repo.VehicleRepo;
import lk.easycarrent.spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addVehicle(VehicleDTO dto) {
        if (repo.existsById(dto.getVehicleID())) {
            throw new ValidateException("Vehicle Already Exist");
        }
        repo.save(mapper.map(dto, Vehicle.class));
    }

    @Override
    public void deleteVehicle(Long id) {
        if (!repo.existsById(id)) {
            throw new ValidateException("No Vehicle for Delete..!");
        }
        repo.deleteById(id);
    }

    @Override
    public VehicleDTO searchVehicle(Long id) {
        Optional<Vehicle> op = repo.findById(id);
        if (op.isPresent()) {
            return mapper.map(op.get(), VehicleDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicle() {
        List<Vehicle> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<VehicleDTO> searchByRegVehicle(String reg) {
        List<Vehicle> all = repo.searchByRegVehicle(reg);
        return mapper.map(all, new TypeToken<ArrayList<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public void updateVehicle(VehicleDTO dto) {
        if (repo.existsById(dto.getVehicleID())) {
            repo.save(mapper.map(dto, Vehicle.class));
        }
    }
}

package lk.easycarrent.spring.service.impl;

import lk.easycarrent.spring.dto.DriverDTO;
import lk.easycarrent.spring.entity.Driver;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.repo.DriverRepo;
import lk.easycarrent.spring.service.DriverService;
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
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addDriver(DriverDTO dto) {
        if (repo.existsById(dto.getDriverID())) {
            throw new ValidateException("Driver Already Exist");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public void deleteDriver(String id) {
        if (!repo.existsById(id)) {
            throw new ValidateException("No Driver for Delete..!");
        }
        repo.deleteById(id);
    }

    @Override
    public DriverDTO searchDriver(String id) {
        Optional<Driver> op = repo.findById(id);
        if (op.isPresent()) {
            return mapper.map(op.get(), DriverDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        List<Driver> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (repo.existsById(dto.getDriverID())) {
            repo.save(mapper.map(dto, Driver.class));
        }
    }
}

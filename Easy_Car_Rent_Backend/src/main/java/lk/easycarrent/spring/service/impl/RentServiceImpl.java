package lk.easycarrent.spring.service.impl;

import lk.easycarrent.spring.dto.RentDTO;
import lk.easycarrent.spring.entity.Rent;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.repo.RentRepo;
import lk.easycarrent.spring.service.RentService;
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
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addRent(RentDTO dto) {
        if (repo.existsById(dto.getRentID())) {
            throw new ValidateException("Rent Already Exist");
        }
        repo.save(mapper.map(dto, Rent.class));
    }

    @Override
    public void deleteRent(String id) {
        if (!repo.existsById(id)) {
            throw new ValidateException("No Rent for Delete..!");
        }
        repo.deleteById(id);
    }

    @Override
    public RentDTO searchRent(String id) {
        Optional<Rent> op = repo.findById(id);
        if (op.isPresent()) {
            return mapper.map(op.get(), RentDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<RentDTO> getAllRent() {
        List<Rent> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<RentDTO>>() {
        }.getType());
    }

    @Override
    public void updateRent(RentDTO dto) {
        if (repo.existsById(dto.getRentID())) {
            repo.save(mapper.map(dto, Rent.class));
        }
    }
}

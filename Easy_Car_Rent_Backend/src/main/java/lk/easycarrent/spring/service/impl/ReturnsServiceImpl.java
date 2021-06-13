package lk.easycarrent.spring.service.impl;

import lk.easycarrent.spring.dto.ReturnsDTO;
import lk.easycarrent.spring.entity.Returns;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.repo.ReturnsRepo;
import lk.easycarrent.spring.service.ReturnsService;
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
public class ReturnsServiceImpl implements ReturnsService {

    @Autowired
    private ReturnsRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addReturns(ReturnsDTO dto) {
        if (repo.existsById(dto.getReturnsID())) {
            throw new ValidateException("Returns Already Exist");
        }
        repo.save(mapper.map(dto, Returns.class));
    }

    @Override
    public void deleteReturns(String id) {
        if (!repo.existsById(id)) {
            throw new ValidateException("No Returns for Delete..!");
        }
        repo.deleteById(id);
    }

    @Override
    public ReturnsDTO searchReturns(String id) {
        Optional<Returns> op = repo.findById(id);
        if (op.isPresent()) {
            return mapper.map(op.get(), ReturnsDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<ReturnsDTO> getAllReturns() {
        List<Returns> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<ReturnsDTO>>() {
        }.getType());
    }

    @Override
    public void updateReturns(ReturnsDTO dto) {
        if (repo.existsById(dto.getReturnsID())) {
            repo.save(mapper.map(dto, Returns.class));
        }
    }
}

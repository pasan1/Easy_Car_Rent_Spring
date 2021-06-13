package lk.easycarrent.spring.service.impl;

import lk.easycarrent.spring.dto.MaintainDTO;
import lk.easycarrent.spring.entity.Maintain;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.repo.MaintainRepo;
import lk.easycarrent.spring.service.MaintainService;
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
public class MaintainServiceImpl implements MaintainService {

    @Autowired
    private MaintainRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addMaintain(MaintainDTO dto) {
        if (repo.existsById(dto.getMaintainID())) {
            throw new ValidateException("Maintain Already Exist");
        }
        repo.save(mapper.map(dto, Maintain.class));
    }

    @Override
    public void deleteMaintain(String id) {
        if (!repo.existsById(id)) {
            throw new ValidateException("No Maintain for Delete..!");
        }
        repo.deleteById(id);
    }

    @Override
    public MaintainDTO searchMaintain(String id) {
        Optional<Maintain> op = repo.findById(id);
        if (op.isPresent()) {
            return mapper.map(op.get(), MaintainDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<MaintainDTO> getAllMaintain() {
        List<Maintain> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<MaintainDTO>>() {
        }.getType());
    }

    @Override
    public void updateMaintain(MaintainDTO dto) {
        if (repo.existsById(dto.getMaintainID())) {
            repo.save(mapper.map(dto, Maintain.class));
        }
    }
}

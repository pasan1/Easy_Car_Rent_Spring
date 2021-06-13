package lk.easycarrent.spring.service.impl;

import lk.easycarrent.spring.dto.DamageDTO;
import lk.easycarrent.spring.entity.Damage;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.repo.DamageRepo;
import lk.easycarrent.spring.service.DamageService;
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
public class DamageServiceImpl implements DamageService {

    @Autowired
    private DamageRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addDamage(DamageDTO dto) {
        if (repo.existsById(dto.getDamageID())) {
            throw new ValidateException("Damage Already Exist");
        }
        repo.save(mapper.map(dto, Damage.class));
    }

    @Override
    public void deleteDamage(String id) {
        if (!repo.existsById(id)) {
            throw new ValidateException("No Damage for Delete..!");
        }
        repo.deleteById(id);
    }

    @Override
    public DamageDTO searchDamage(String id) {
        Optional<Damage> op = repo.findById(id);
        if (op.isPresent()) {
            return mapper.map(op.get(), DamageDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<DamageDTO> getAllDamage() {
        List<Damage> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<DamageDTO>>() {
        }.getType());
    }

    @Override
    public void updateDamage(DamageDTO dto) {
        if (repo.existsById(dto.getDamageID())) {
            repo.save(mapper.map(dto, Damage.class));
        }
    }
}

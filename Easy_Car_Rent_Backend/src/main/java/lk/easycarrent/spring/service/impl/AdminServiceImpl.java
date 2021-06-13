package lk.easycarrent.spring.service.impl;

import lk.easycarrent.spring.dto.AdminDTO;
import lk.easycarrent.spring.entity.Admin;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.repo.AdminRepo;
import lk.easycarrent.spring.service.AdminService;
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
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getAdminID())) {
            throw new ValidateException("Admin Already Exist");
        }
        repo.save(mapper.map(dto, Admin.class));
    }

    @Override
    public void deleteAdmin(String id) {
        if (!repo.existsById(id)) {
            throw new ValidateException("No Admin for Delete..!");
        }
        repo.deleteById(id);
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        Optional<Admin> op = repo.findById(id);
        if (op.isPresent()) {
            return mapper.map(op.get(), AdminDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmin() {
        List<Admin> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<AdminDTO>>() {
        }.getType());
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getAdminID())) {
            repo.save(mapper.map(dto, Admin.class));
        }
    }
}

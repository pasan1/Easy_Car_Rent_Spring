package lk.easycarrent.spring.service.impl;

import lk.easycarrent.spring.dto.UserDTO;
import lk.easycarrent.spring.entity.User;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.repo.UserRepo;
import lk.easycarrent.spring.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addUser(UserDTO dto) {
        if (repo.existsById(dto.getUserID())) {
            throw new ValidateException("User Already Exist");
        }
        repo.save(mapper.map(dto, User.class));
    }

    @Override
    public void deleteUser(String id) {
        if (!repo.existsById(id)) {
            throw new ValidateException("No User for Delete..!");
        }
        repo.deleteById(id);
    }

    @Override
    public UserDTO searchUser(String id) {
        Optional<User> op = repo.findById(id);
        if (op.isPresent()) {
            return mapper.map(op.get(), UserDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAllUser() {
        List<User> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (repo.existsById(dto.getUserID())) {
            repo.save(mapper.map(dto, User.class));
        }
    }
}

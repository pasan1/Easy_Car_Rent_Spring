package lk.easycarrent.spring.service;


import lk.easycarrent.spring.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {
    void addUser(UserDTO dto);

    void deleteUser(String id);

    UserDTO searchUser(String id);

    ArrayList<UserDTO> getAllUser();

    void updateUser(UserDTO dto);
}

package lk.easycarrent.spring.service;

import lk.easycarrent.spring.dto.AdminDTO;

import java.util.ArrayList;

public interface AdminService {
    void addAdmin(AdminDTO dto);

    void deleteAdmin(String id);

    AdminDTO searchAdmin(String id);

    ArrayList<AdminDTO> getAllAdmin();

    void updateAdmin(AdminDTO dto);
}

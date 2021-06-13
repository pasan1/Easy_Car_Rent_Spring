package lk.easycarrent.spring.service;

import lk.easycarrent.spring.dto.MaintainDTO;

import java.util.ArrayList;

public interface MaintainService {
    void addMaintain(MaintainDTO dto);

    void deleteMaintain(String id);

    MaintainDTO searchMaintain(String id);

    ArrayList<MaintainDTO> getAllMaintain();

    void updateMaintain(MaintainDTO dto);
}

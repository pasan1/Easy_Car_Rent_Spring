package lk.easycarrent.spring.service;


import lk.easycarrent.spring.dto.ReturnsDTO;

import java.util.ArrayList;

public interface ReturnsService {
    void addReturns(ReturnsDTO dto);

    void deleteReturns(String id);

    ReturnsDTO searchReturns(String id);

    ArrayList<ReturnsDTO> getAllReturns();

    void updateReturns(ReturnsDTO dto);
}

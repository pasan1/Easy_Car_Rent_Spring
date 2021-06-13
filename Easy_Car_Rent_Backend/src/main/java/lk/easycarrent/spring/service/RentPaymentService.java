package lk.easycarrent.spring.service;


import lk.easycarrent.spring.dto.RentPaymentDTO;

import java.util.ArrayList;

public interface RentPaymentService {
    void addRentPayment(RentPaymentDTO dto);

    void deleteRentPayment(String id);

    RentPaymentDTO searchRentPayment(String id);

    ArrayList<RentPaymentDTO> getAllRentPayment();

    void updateRentPayment(RentPaymentDTO dto);
}

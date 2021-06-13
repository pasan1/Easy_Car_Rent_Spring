package lk.easycarrent.spring.service.impl;

import lk.easycarrent.spring.dto.RentPaymentDTO;
import lk.easycarrent.spring.entity.RentPayment;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.repo.RentPaymentRepo;
import lk.easycarrent.spring.service.RentPaymentService;
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
public class RentPaymentServiceImpl implements RentPaymentService {

    @Autowired
    private RentPaymentRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addRentPayment(RentPaymentDTO dto) {
        if (repo.existsById(dto.getPaymentID())) {
            throw new ValidateException("Payment Already Exist");
        }
        repo.save(mapper.map(dto, RentPayment.class));
    }

    @Override
    public void deleteRentPayment(String id) {
        if (!repo.existsById(id)) {
            throw new ValidateException("No Payment for Delete..!");
        }
        repo.deleteById(id);
    }

    @Override
    public RentPaymentDTO searchRentPayment(String id) {
        Optional<RentPayment> op = repo.findById(id);
        if (op.isPresent()) {
            return mapper.map(op.get(), RentPaymentDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<RentPaymentDTO> getAllRentPayment() {
        List<RentPayment> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<RentPaymentDTO>>() {
        }.getType());
    }

    @Override
    public void updateRentPayment(RentPaymentDTO dto) {
        if (repo.existsById(dto.getPaymentID())) {
            repo.save(mapper.map(dto, RentPayment.class));
        }
    }
}

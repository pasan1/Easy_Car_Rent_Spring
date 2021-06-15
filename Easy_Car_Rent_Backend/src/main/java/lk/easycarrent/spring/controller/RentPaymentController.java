package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.RentPaymentDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.service.RentPaymentService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/rentpayment")
@CrossOrigin
public class RentPaymentController {

    @Autowired
    private RentPaymentService service;

    @GetMapping(path = "search")
    public ResponseEntity searchRentPayment(String id) {
        RentPaymentDTO dto = service.searchRentPayment(id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveRentPayment(@RequestBody RentPaymentDTO dto) {
        if (dto.getPaymentID().trim().length() <= 0) {
            throw new NotFoundException("Rent Payment ID cannot be empty");
        }
        service.addRentPayment(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateRentPayment(@RequestBody RentPaymentDTO dto) {
        if (dto.getPaymentID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateRentPayment(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteRentPayment(String id) {
        service.deleteRentPayment(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllRentPayment() {
        ArrayList<RentPaymentDTO> all = service.getAllRentPayment();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }
}

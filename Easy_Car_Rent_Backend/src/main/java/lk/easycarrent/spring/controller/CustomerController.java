package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.CustomerDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.service.CustomerService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(path = "search")
    public ResponseEntity searchCustomer(String id) {
        CustomerDTO dto = service.searchCustomer(id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
        if (dto.getCustomerID().trim().length() <= 0 || dto.getAddress().trim().length() <= 0 ||
                dto.getFirstName().trim().length() <= 0 || dto.getLasTName().trim().length() <= 0 ||
                dto.getContactNumber().trim().length() <= 0 || dto.getDriveLicenseNumber().trim().length() <= 0 ||
                dto.getNicNumber().trim().length() <= 0) {
            throw new ValidateException("Fields Can't be empty");
        }
        service.addCustomer(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        if (dto.getCustomerID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateCustomer(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteCustomer(String id) {
        service.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomer() {
        ArrayList<CustomerDTO> allCustomers = service.getAllCustomers();
        return new ResponseEntity(new StandardResponse("200", "Done", allCustomers), HttpStatus.OK);
    }

}

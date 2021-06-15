package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.RentDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.service.RentService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/rent")
@CrossOrigin
public class RentController {

    @Autowired
    private RentService service;

    @GetMapping(path = "search")
    public ResponseEntity searchRent(String id) {
        RentDTO dto = service.searchRent(id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveRent(@RequestBody RentDTO dto) {
        if (dto.getRentID().trim().length() <= 0) {
            throw new NotFoundException("Rent ID cannot be empty");
        }
        service.addRent(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateRent(@RequestBody RentDTO dto) {
        if (dto.getRentID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateRent(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteRent(String id) {
        service.deleteRent(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllRent() {
        ArrayList<RentDTO> all = service.getAllRent();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }
}

package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.DriverDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.service.DriverService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping(path = "search")
    public ResponseEntity searchDriver(String id) {
        DriverDTO dto = service.searchDriver(id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveDriver(@RequestBody DriverDTO dto) {
        if (dto.getDriverID().trim().length() <= 0) {
            throw new NotFoundException("Driver ID cannot be empty");
        }
        service.addDriver(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateDriver(@RequestBody DriverDTO dto) {
        if (dto.getDriverID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateDriver(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteDriver(String id) {
        service.deleteDriver(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDriver() {
        ArrayList<DriverDTO> all = service.getAllDriver();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }
}

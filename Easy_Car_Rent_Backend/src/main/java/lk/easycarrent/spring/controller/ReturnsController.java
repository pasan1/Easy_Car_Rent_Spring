package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.ReturnsDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.service.ReturnsService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/returns")
public class ReturnsController {

    @Autowired
    private ReturnsService service;

    @GetMapping(path = "search")
    public ResponseEntity searchReturns(String id) {
        ReturnsDTO dto = service.searchReturns(id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveReturns(@RequestBody ReturnsDTO dto) {
        if (dto.getReturnsID().trim().length() <= 0) {
            throw new NotFoundException("Rent Returns ID cannot be empty");
        }
        service.addReturns(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateReturns(@RequestBody ReturnsDTO dto) {
        if (dto.getReturnsID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateReturns(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteReturns(String id) {
        service.deleteReturns(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllReturns() {
        ArrayList<ReturnsDTO> all = service.getAllReturns();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }
}

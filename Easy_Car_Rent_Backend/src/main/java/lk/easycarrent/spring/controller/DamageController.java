package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.DamageDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.service.DamageService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/damage")
public class DamageController {

    @Autowired
    private DamageService service;

    @GetMapping(path = "search")
    public ResponseEntity searchDamage(String id) {
        DamageDTO dto = service.searchDamage(id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveDamage(@RequestBody DamageDTO dto) {
        if (dto.getDamageID().trim().length() <= 0) {
            throw new NotFoundException("Damage ID cannot be empty");
        }
        service.addDamage(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateDamage(@RequestBody DamageDTO dto) {
        if (dto.getDamageID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateDamage(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteDamage(String id) {
        service.deleteDamage(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDamage() {
        ArrayList<DamageDTO> all = service.getAllDamage();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }
}

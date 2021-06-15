package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.MaintainDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.service.MaintainService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/maintain")
@CrossOrigin
public class MaintainController {

    @Autowired
    private MaintainService service;

    @GetMapping(path = "search")
    public ResponseEntity searchMaintain(String id) {
        MaintainDTO dto = service.searchMaintain(id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveMaintain(@RequestBody MaintainDTO dto) {
        if (dto.getMaintainID().trim().length() <= 0) {
            throw new NotFoundException("Maintain ID cannot be empty");
        }
        service.addMaintain(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateMaintain(@RequestBody MaintainDTO dto) {
        if (dto.getMaintainID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateMaintain(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteMaintain(String id) {
        service.deleteMaintain(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllMaintain() {
        ArrayList<MaintainDTO> all = service.getAllMaintain();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }
}

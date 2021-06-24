package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.VehicleDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.service.VehicleService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchVehicle(@PathVariable String id) {
        VehicleDTO dto = service.searchVehicle(Long.valueOf(id));
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveVehicle(@RequestBody VehicleDTO dto) {
        if (dto.getVehicleID() <= 0) {
            throw new NotFoundException("Rent Vehicle ID cannot be empty");
        }
        service.addVehicle(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateVehicle(@RequestBody VehicleDTO dto) {
        if (dto.getVehicleID() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateVehicle(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity deleteVehicle(@PathVariable String id) {
        service.deleteVehicle(Long.valueOf(id));
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllVehicle() {
        ArrayList<VehicleDTO> all = service.getAllVehicle();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }

    @GetMapping(path = "searchByReg/{id}")
    public ResponseEntity searchByRegVehicle(@PathVariable String reg) {
        ArrayList<VehicleDTO> all = service.searchByRegVehicle(reg);
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }
}

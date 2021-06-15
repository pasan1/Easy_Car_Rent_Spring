package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.ScheduleDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.service.ScheduleService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/schedule")
@CrossOrigin
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @GetMapping(path = "search")
    public ResponseEntity searchSchedule(String id) {
        ScheduleDTO dto = service.searchSchedule(id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveSchedule(@RequestBody ScheduleDTO dto) {
        if (dto.getScheduleID().trim().length() <= 0) {
            throw new NotFoundException("Rent Schedule ID cannot be empty");
        }
        service.addSchedule(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateSchedule(@RequestBody ScheduleDTO dto) {
        if (dto.getScheduleID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateSchedule(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteSchedule(String id) {
        service.deleteSchedule(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllSchedule() {
        ArrayList<ScheduleDTO> all = service.getAllSchedule();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }
}

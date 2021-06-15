package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.AdminDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.service.AdminService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping(path = "search")
    public ResponseEntity searchAdmin(String id) {
        AdminDTO dto = service.searchAdmin(id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveAdmin(@RequestBody AdminDTO dto) {
        if (dto.getAdminID().trim().length() <= 0) {
            throw new NotFoundException("Admin ID cannot be empty");
        }
        service.addAdmin(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateAdmin(@RequestBody AdminDTO dto) {
        if (dto.getAdminID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateAdmin(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteAdmin(String id) {
        service.deleteAdmin(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllAdmin() {
        ArrayList<AdminDTO> all = service.getAllAdmin();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }
}

package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.dto.UserDTO;
import lk.easycarrent.spring.exception.NotFoundException;
import lk.easycarrent.spring.service.UserService;
import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrent/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(path = "search")
    public ResponseEntity searchUser(String id) {
        UserDTO dto = service.searchUser(id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDTO dto) {
        if (dto.getUserID().trim().length() <= 0) {
            throw new NotFoundException("Rent User ID cannot be empty");
        }
        service.addUser(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserDTO dto) {
        if (dto.getUserID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateUser(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteUser(String id) {
        service.deleteUser(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUser() {
        ArrayList<UserDTO> all = service.getAllUser();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }
}

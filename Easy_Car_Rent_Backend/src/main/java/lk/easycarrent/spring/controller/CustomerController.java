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
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService service;

    private static final String UPLOADED_FOLDER = "lk/easycarrent/spring/saveFile/customer";

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDTO dto = service.searchCustomer(Long.valueOf(id));
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
//        if (dto.getCustomerID().trim().length() <= 0 || dto.getAddress().trim().length() <= 0 ||
//                dto.getFirstName().trim().length() <= 0 || dto.getLastName().trim().length() <= 0 ||
//                dto.getContactNumber().trim().length() <= 0 || dto.getDriveLicenseNumber().trim().length() <= 0 ||
//                dto.getNic().trim().length() <= 0) {
//            throw new ValidateException("Fields Can't be empty");
//        }
        System.out.println("saveCustomer(controller) : "+dto);
        service.addCustomer(dto);

        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        if (dto.getCustomerID() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateCustomer(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable String id) {
        service.deleteCustomer(Long.valueOf(id));
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomer() {
        ArrayList<CustomerDTO> allCustomers = service.getAllCustomers();
        return new ResponseEntity(new StandardResponse("200", "Done", allCustomers), HttpStatus.OK);
    }

    @GetMapping(path = "searchByName/{name}")
    public ResponseEntity searchByName(@PathVariable String name) {
        ArrayList<CustomerDTO> allCustomers = service.SearchCustomersByName(name);
        return new ResponseEntity(new StandardResponse("200", "Done", allCustomers), HttpStatus.OK);
    }

//    @PostMapping(path = "/{upload}")
//    public ResponseEntity upload(@RequestParam("file") MultipartFile[] file, @RequestParam("id") String id) throws JsonProcessingException {
//
//        ObjectMapper mapper =new ObjectMapper();
//
//        CustomerDTO customerDTO=mapper.readValue(id,CustomerDTO.class);
//
//        for (MultipartFile files : file) {
//
//            String fileNames = UUID.randomUUID().toString();
//            String contentType = files.getContentType();
//            String[] split = contentType.split("/");
//
//            File destinationFile = new File(UPLOADED_FOLDER + fileNames + "." + split[1]);
//
//            try {
//
//                files.transferTo(destinationFile);
//
//                CustomerNicImageDTO nicImage = new CustomerNicImageDTO(customerDTO.getNic(), "assests/Image/CustomerNicImage/"+fileNames+"."+split[1]);
//                service.addCustomer(customerDTO);
//                nicImageService.addCustomerNicImage(nicImage);
//
//
//            } catch (Exception e) {
//
//                e.printStackTrace();
//            }
//        }
//
//        StandardResponse response = new StandardResponse("200", "Success", null);
//        return new ResponseEntity(response, HttpStatus.CREATED);
//    }
}

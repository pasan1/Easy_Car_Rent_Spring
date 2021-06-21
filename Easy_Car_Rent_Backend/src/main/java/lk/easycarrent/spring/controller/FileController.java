package lk.easycarrent.spring.controller;

import lk.easycarrent.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    private static final String UPLOADED_FOLDER = "D:\\IJSE\\GDSE55\\2 sem\\Advanced API Development with Spring Web MVC\\Course Work\\Easy_Car_Rent\\Easy_Car_Rent_Frontend\\uploads";

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveFile(@RequestPart("myFile") MultipartFile myFile) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(UPLOADED_FOLDER + "/uploads");
            uploadsDir.mkdir();
            File toFile = new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename());
            myFile.transferTo(toFile);
            System.out.println(toFile.getAbsolutePath());
            String filePath = toFile.getAbsolutePath();
            return new ResponseEntity(new StandardResponse("201", "Done", filePath), HttpStatus.CREATED);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
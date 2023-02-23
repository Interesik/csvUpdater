package kazusek.csvupdater.controllers;

import kazusek.csvupdater.Services.CSVStorageImp;
import kazusek.csvupdater.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class UploadnigFiles {
    @Autowired
    CSVStorageImp CSVStorageImp;
    @PostMapping("/")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file", required = false) MultipartFile file) {
        CSVStorageImp.save(file);
        String message;
        try {
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
    @GetMapping("/")
    public List<Client> getSite() {
        return CSVStorageImp.loadAll();
    }
}

package kazusek.csvupdater.controllers;

import kazusek.csvupdater.Services.FileStorageImp;
import kazusek.csvupdater.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class UploadnigFiles {
    @Autowired
    FileStorageImp fileStorageImp;
    @PostMapping("/")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file", required = false) MultipartFile file) {
        fileStorageImp.save(file);
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
        return fileStorageImp.loadAll();
    }
}

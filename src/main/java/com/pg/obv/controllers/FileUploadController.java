package com.pg.obv.controllers;


import com.pg.obv.fileUpload.FileUploadHelper;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController  {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("image")MultipartFile file){
        try{
            Boolean check = fileUploadHelper.fileUploadOrNot(file);
            if(check)
                return new ResponseEntity<>(ServletUriComponentsBuilder.fromCurrentContextPath().path("images/").path(file.getOriginalFilename()).toUriString(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
    }
}

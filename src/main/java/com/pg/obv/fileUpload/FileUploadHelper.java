package com.pg.obv.fileUpload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    private final String UPLOAD_DIR= "/home/prafull/Documents/workspace-spring-tool-suite-4-4.13.0.RELEASE/Oblivion/src/main/resources/static/images";

    public boolean fileUploadOrNot(MultipartFile file) throws IOException {
    boolean fal = false;

//        InputStream input = file.getInputStream();
//        byte data[]= new byte[input.available()];
//        input.read(data);
//        //write
//        FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"/");
//        System.out.println(fos);
//        fos.write(data);
//        fos.flush();
//        fos.close();
            try{
                Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                fal = true;
            }
            catch (Exception e){
                fal = false;
            }
    return fal;
    }
}

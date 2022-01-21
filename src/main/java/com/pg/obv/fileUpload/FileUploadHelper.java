package com.pg.obv.fileUpload;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

    private final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {
    }

    public boolean fileUploadOrNot(MultipartFile file){
    boolean fal = false;

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











//-------------------------
//private final String UPLOAD_DIR= "/home/prafull/Documents/workspace-spring-tool-suite-4-4.13.0.RELEASE/Oblivion/src/main/resources/static/images";
//        InputStream input = file.getInputStream();
//        byte data[]= new byte[input.available()];
//        input.read(data);
//        //write
//        FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"/");
//        System.out.println(fos);
//        fos.write(data);
//        fos.flush();
//        fos.close();
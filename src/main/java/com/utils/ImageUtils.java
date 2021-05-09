package com.utils;

import com.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.File;
import org.apache.commons.io.FilenameUtils;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class ImageUtils {

    @Autowired
    private static ServletContext context;

    public static void getImage(Product product){
        String imageName = null;
        String image = null;
        List<String> images = new ArrayList <>();

       String path = String.valueOf(Paths.get("F://youTube videos/spring-apis/uploads/"));
        System.out.println(path);
        File fileFolder = new File(path);
        if(fileFolder!=null){
            for(final File file : fileFolder.listFiles()){
                if(!file.isDirectory()){
                    if(product.getpPhoto().equalsIgnoreCase(file.getName())){
                        String encodeBase64 = null;
                        try {
                            String extention = FilenameUtils.getExtension(file.getName());
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bytes = new byte[(int)file.length()];
                            fileInputStream.read(bytes);
                            encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                            images.add("data:image/"+extention+";base64,"+encodeBase64);

                            product.setpPhoto("data:image/"+extention+";base64,"+encodeBase64);
                            fileInputStream.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                }
            }
        }

    }

}

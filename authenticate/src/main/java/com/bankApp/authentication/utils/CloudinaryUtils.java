package com.bankApp.authentication.utils;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CloudinaryUtils {
    public Map<String, String> uploadDoc(File file,String name, String saveFolder) {
        // Configure
        Map config = new HashMap();
        config.put("cloud_name", "ddfjno1ok");
        config.put("api_key", "947771583565624");
        config.put("api_secret", "512zEIS3eD9Xg_M0cRHFOWwE_hg");
        Cloudinary cloudinary = new Cloudinary(config);

        Map result = null;
// Upload
        try {
//            File file = new File("/Users/bukolataiwo/Documents/Personal/BankApplication/authenticate/src/main/resources/img.png");
             result = cloudinary.uploader().upload(file, ObjectUtils.asMap(saveFolder, name, true));
//            Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", "Test101",true));
            log.info("Result " + result.toString());
//            cloudinary.uploader().upload("https://upload.wikimedia.org/wikipedia/commons/a/ae/Olympic_flag.jpg", ObjectUtils.asMap("public_id", "olympic_flag"));


        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return result;
    }

// Transform
//        String url = cloudinary.url().transformation(new Transformation().width(100).height(150).crop("fill")).generate("olympic_flag");
//        System.out.println(url);
//    }

//    public static void main(String[] args) {
//        File file = new File("/Users/bukolataiwo/Documents/Personal/BankApplication/authenticate/src/main/resources/img.png");
//        uploadDoc(file,"Test101","BankApp");
//    }
}

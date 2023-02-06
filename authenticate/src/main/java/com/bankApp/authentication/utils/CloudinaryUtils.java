package com.bankApp.authentication.utils;


import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CloudinaryUtils {


    public void uploadDoc(){
        // Configure
        Map config = new HashMap();
        config.put("cloud_name", "ddfjno1ok");
        config.put("api_key", "947771583565624");
        config.put("api_secret", "512zEIS3eD9Xg_M0cRHFOWwE_hg");
        Cloudinary cloudinary = new Cloudinary(config);


// Upload
        try {
            cloudinary.uploader().upload("https://upload.wikimedia.org/wikipedia/commons/a/ae/Olympic_flag.jpg", ObjectUtils.asMap("public_id", "olympic_flag"));
            cloudinary.uploader().upload("https://upload.wikimedia.org/wikipedia/commons/a/ae/Olympic_flag.jpg", ObjectUtils.asMap("public_id", "olympic_flag"));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

// Transform
//        String url = cloudinary.url().transformation(new Transformation().width(100).height(150).crop("fill")).generate("olympic_flag");
//        System.out.println(url);
    }
}

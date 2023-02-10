package com.bankApp.authentication.documentMgt.controller;

import com.bankApp.authentication.documentMgt.dto.request.UploadRequest;
import com.bankApp.authentication.utils.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadDocController {

    public Response uploadDoc(@RequestBody UploadRequest uploadRequest, @RequestBody MultipartFile multipartFile){

        return null;

    }
}

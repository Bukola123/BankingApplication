package com.bankApp.authentication.documentMgt.service;

import com.bankApp.authentication.documentMgt.dto.request.UploadRequest;
import com.bankApp.authentication.documentMgt.model.IdDetails;
import com.bankApp.authentication.documentMgt.model.Utility;
import com.bankApp.authentication.documentMgt.repo.IdDetailsRepo;
import com.bankApp.authentication.documentMgt.repo.UtilityRepo;
import com.bankApp.authentication.utils.CloudinaryUtils;
import com.bankApp.authentication.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Map;

public class UploadDocumentService {

    @Autowired
    CloudinaryUtils cloudinaryUtils;

    @Autowired
    IdDetailsRepo idDetailsRepo;

    @Autowired
    UtilityRepo utilityRepo;

    public Response uploadDoc(UploadRequest uploadRequest){

        Response response = new Response();
        File file = new File(uploadRequest.getCloudinary().getName());
        //Send to cloudinary
        Map<String, String> resp = cloudinaryUtils.uploadDoc(file, file.getName(), uploadRequest.getDocType());

        //Save to DB

        if(resp.get("url") != null){

            if(uploadRequest.getDocType().equalsIgnoreCase("ID")){
                IdDetails idDetails = new IdDetails();
                idDetailsRepo.save(idDetails);
            } else if (uploadRequest.getDocType().equalsIgnoreCase("UTILITY")){

                Utility utility = new Utility();
                utilityRepo.save(utility);

            }

        }else{
            response.setResponseCode("99");
            response.setResponseMessage("Document upload failed");
        }


        return null;
    }
}

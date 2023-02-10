package com.bankApp.authentication.documentMgt.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class UploadRequest {

//    private String docId;
    private String accountNo;
    private String passport;
    private String docName;
    private String docType;  //ID,Utility...
    private String docSubType;
    private String docSubStatuse;
    private String idNumber;
    private String idSigned;
    private String iDLocation;
    private String verifiedBy;
    private String approvedBy;
    private MultipartFile cloudinary;
    private String dateVerified;
    private String idComment;
    private String utilityAddress;

}

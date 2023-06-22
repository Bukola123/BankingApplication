package com.bankApp.bankList.service;

import com.bankApp.bankList.dto.response.GetBankListResponse;
import com.bankApp.utils.Response;
import com.bankApp.utils.exemptions.GeneralExceptions;
import com.bankApp.utils.general.enums.ResponseCodes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetBankListServiceImpl  implements GetBankListServiceInterface{

    @Autowired
    RestTemplate restTemplate;

    @Value("${getBankListFromPaystack}")
    private String bankListUrl;

    @Value("${paystackSecretKey}")
    private String paystackSecretKey;

    public Response getBankList(String country){

        Response response = new Response();
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "Bearer " + paystackSecretKey);

            HttpEntity<?> requestEntity = new HttpEntity<>(country, httpHeaders);

            ResponseEntity<GetBankListResponse> getBankListResponse = restTemplate.exchange(bankListUrl, HttpMethod.GET, requestEntity, GetBankListResponse.class);

            if(getBankListResponse == null){
                response.setResponseCode("99");
                response.setResponseMessage("No Response from Host");
            }else {
                response.setResponseCode(getBankListResponse.getBody().getStatus());
                response.setResponseMessage(getBankListResponse.getBody().getMessage());
                response.setData(getBankListResponse.getBody());
            }

        }catch (Exception e){
            throw new GeneralExceptions("99","Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }
}

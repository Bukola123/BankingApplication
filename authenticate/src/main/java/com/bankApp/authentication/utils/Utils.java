package com.bankApp.authentication.utils;

import com.bankApp.authentication.auth.dto.request.CreateUserRequest;
import com.bankApp.authentication.auth.dto.request.LoginUserRequest;
import com.bankApp.authentication.auth.dto.request.MobileAppRegRequest;
import com.bankApp.authentication.auth.model.MobileBankingDetails;
import com.bankApp.authentication.auth.model.User;
import com.bankApp.authentication.auth.repository.MobileBankingRepository;
import com.bankApp.authentication.auth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class Utils {


    @Autowired
    UserRepository userRepository;


    @Autowired
    MobileBankingRepository mobileBankingRepository;
    public static String generateRandomNo(int max){

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < max; i++){
            stringBuilder.append(Math.round(Math.random() * 9));
        }
//		System.out.println(stringBuilder.toString() + " : " + stringBuilder.toString().length() + " : Max " + max);
        return stringBuilder.toString();
    }


    public MobileBankingDetails validateUserName(LoginUserRequest request){
        log.info("MobileBankingDetails Request {}", request);
        MobileAppRegRequest mobileAppRegRequest = new MobileAppRegRequest();
        MobileBankingDetails mobileBankingDetails = mobileBankingRepository.findByUsername(request.getUserName());

        log.info("MobileBankingDetails Response {}", mobileBankingDetails);

        if(mobileBankingDetails != null)
        {
            return mobileBankingDetails;
        }
        return null;
    }


    public User findByEmail(CreateUserRequest createUserRequest){
        User user = new User();
//        return userRepository.findByEmail(email);
        log.info("Email {}", createUserRequest.getEmail());
        user = userRepository.findByEmail(createUserRequest.getEmail());
        log.info("User here {}", user);
        return user ;
    }



}
